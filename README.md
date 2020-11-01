
[![Build Status](https://travis-ci.com/cmccarthyIrl/spring-karate-test-harness.svg?branch=master)](https://travis-ci.com/cmccarthyIrl/spring-karate-test-harness)

<table> 
<tr>
  <th>Start</th>
  <td>
    | <a href="#maven">Maven</a> | 
  </td>
</tr>
<tr>
  <th>Run</th>
  <td>
     | <a href="#junit">Karate</a>
    | <a href="#command-line">Command Line</a>
    | <a href="#cucumber-html-reports">Reporting</a>
    | <a href="#troubleshooting">Troubleshooting</a> |
  </td>
</tr>
<tr>
  <th>Advanced</th>
  <td>
    | <a href="#contributing">Contributing</a> |
    </td>
</tr>
</table>
    
# Maven

The Framework uses [Spring Boot Test](https://spring.io/guides/gs/testing-web/) and  [Karate](https://cucumber.io/), client implementations.

Spring `<dependencies>`:

```xml
<dependecies>
    ...
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit</artifactId>
            <version>${spring-rabbit.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
        </dependency>
    ...
</dependecies>
```
Karate `<dependencies>`:
```xml
<dependecies>
    ...
    <dependency>
            <groupId>com.intuit.karate</groupId>
            <artifactId>karate-apache</artifactId>
            <version>${karate.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.intuit.karate</groupId>
            <artifactId>karate-junit5</artifactId>
            <version>${karate.version}</version>
            <scope>test</scope>
        </dependency>
    ...
</dependecies>
```

# Command Line 

Normally you will use your IDE to run a `*.feature` file directly or via the `*Test.java` class. With the `Test` class, we can run tests from the command-line as well.

Note that the `mvn test` command only runs test classes that follow the `*Test.java` naming convention. 

You can run a single test or a suite or tests like so :

```
mvn test -Dtest=HeroKarateTest
```

Note that the `mvn clean install` command runs all test Classes that follow the `*Test.java` naming convention

```
mvn clean install
```


# Configuration 

The `AbstractTestDefinition` class is responsible for specifying each Step class as `@SpringBootTest` and its `@ContextConfiguration`

> All the `Step Classes` in the Framework should `extend` the `AbstractTestDefinition` class

```java
@ContextConfiguration(classes = {KarateContextConfiguration.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AbstractTestDefinition { }
```

The `KarateContextConfiguration` class is responsible for specifying the Spring `@Configuration`, modules to scan, properties to use etc

```java
@Configuration
@ComponentScan({
        "cmccarthyirl"
})
@PropertySource("classpath:/application.properties")
public class KarateContextConfiguration {
}

```

# Environment Switching

There is only one thing you need to do to switch the environment - which is to set `<activeByDefault>` property in the Master POM.

> By default, the value of `spring.profiles.active` is defined in the `application.properties` file which inherits its value from the Master POM property `<activeByDefault>`

```xml
 <profiles>
        ...
        <profile>
            <id>prod</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <activatedProperties>prod</activatedProperties>
            </properties>
        </profile>
        ...
</profiles>
```

You can then specify the profile to use when running Maven from the command line like so:
```
mvn clean install -P dev
```

Below is an example of the `application.properties` file.

```properties
spring.profiles.active=@activatedProperties@
```

# Cucumber HTML Reports

The Framework uses [Cucumber HTML Reports]()

<img src="https://github.com/cmccarthyIrl/spring-karate-test-harness/blob/master/common/src/main/resources/demo/reporter.png" height="400px"/>


# Cucumber vs Karate
> Karate was based on Cucumber-JVM until version 0.8.0 but the parser and engine were [re-written from scratch](https://github.com/intuit/karate/issues/444) in 0.9.0 onwards. So we use the same [Gherkin](https://docs.cucumber.io/gherkin/) syntax - but the similarity ends there.

If you are familiar with Cucumber (JVM), you may be wondering if you need to write [step-definitions](https://docs.cucumber.io/gherkin/step-organization/). The answer is **no**.

Karate's approach is that all the step-definitions you need in order to work with HTTP, JSON and XML have been already implemented. And since you can easily extend Karate [using JavaScript](#call), there is no need to compile Java code any more.

The following table summarizes some key differences between Cucumber and Karate.

:white_small_square: | Cucumber | Karate
-------------------- | -------- | ------
**Step Definitions Built-In** | **No**. You need to keep implementing them as your functionality grows. [This can get very tedious](https://thepracticaldeveloper.com/2017/08/03/microservices-end-to-end-tests-with-cucumber-and-spring-boot/), especially since for [dependency-injection](https://docs.cucumber.io/cucumber/state/#dependency-injection), you are [on your own](http://angiejones.tech/rest-assured-with-cucumber-using-bdd-for-web-services-automation?refreshed=y#comment-40). | :white_check_mark: **Yes**. No extra Java code needed.
**Single Layer of Code To Maintain** | **No**. There are 2 Layers. The [Gherkin](https://docs.cucumber.io/gherkin/reference/) spec or `*.feature` files make up one layer, and you will also have the corresponding Java step-definitions. | :white_check_mark: **Yes**. Only 1 layer of Karate-script (based on Gherkin).
**Readable Specification** | **Yes**. Cucumber will read like natural language _if_ you implement the step-definitions right. | :x: **No**. Although Karate is simple, and a [true DSL](https://ayende.com/blog/2984/dsl-vs-fluent-interface-compare-contrast), it is ultimately a [mini-programming language](https://hackernoon.com/yes-karate-is-not-true-bdd-698bf4a9be39). But it is [perfect for testing web-services](https://stackoverflow.com/a/47799207/143475) at the level of HTTP requests and responses.
**Re-Use Feature Files** | **No**. Cucumber does not support being able to call (and thus re-use) other `*.feature` files from a test-script. | :white_check_mark: [**Yes**](#calling-other-feature-files).
**Dynamic Data-Driven Testing** | **No**. Cucumber's [`Scenario Outline`](#the-cucumber-way) expects the `Examples` to contain a fixed set of rows. | :white_check_mark: **Yes**. Karate's support for calling other `*.feature` files allows you to use a [JSON array as the data-source](#data-driven-features) and you can [use JSON](https://twitter.com/KarateDSL/status/1051433711814627329) or [even CSV](#csv-files) directly in a data-driven `Scenario Outline`.
**Parallel Execution** | **No**. There are some challenges (especially with reporting) and you can find various discussions and third-party projects on the web that attempt to close this gap: [1](https://github.com/cucumber/cucumber-jvm/issues/630) [2](https://opencredo.com/test-automation-concepts-parallel-test-execution/) [3](http://stackoverflow.com/questions/41034116/how-to-execute-cucumber-feature-file-parallel) [4](https://github.com/DisneyStudios/cucumber-slices-maven-plugin) [5](https://github.com/temyers/cucumber-jvm-parallel-plugin) [6](https://github.com/trivago/cucable-plugin) [7](https://github.com/eu-evops/cucumber-runner-maven-plugin) [8](https://automationrhapsody.com/running-cucumber-tests-in-parallel/) | :white_check_mark: [**Yes**](#parallel-execution). Karate runs even `Scenario`-s in parallel, not just `Feature`-s.
**Run 'Set-Up' Routines Only Once** | **No**. Cucumber has a limitation where `Background` steps are re-run for every `Scenario` and worse - even for every `Examples` row within a `Scenario Outline`. This has been a [highly-requested open issue](https://github.com/cucumber/cucumber-jvm/issues/515) for a *long* time. | :white_check_mark: [**Yes**](#hooks).
**Embedded JavaScript Engine** | **No**. And you have to roll your own approach to environment-specific configuration and worry about [dependency-injection](https://docs.cucumber.io/cucumber/state/#dependency-injection). | :white_check_mark: **Yes**. Easily define all environments in a [single file](#configuration) and share variables across all scenarios. Full script-ability via [JS](#calling-javascript-functions) or [Java interop](#java-interop).

# Troubleshooting

- Execute the following commands to resolve any dependency issues
    1. `cd ~/install directory path/spring-karate-test-harness`
    2. `mvn clean install -DskipTests`
    3. `execute the Karate test`
    
# Contributing

Spotted a mistake? Questions? Suggestions?

[Open an Issue](https://github.com/cmccarthyIrl/spring-cucumber-test-harness/issues)


