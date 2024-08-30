# Karate Test Framework
[![Karate Tests - SpringBoot APP](https://github.com/cmccarthyIrl/spring-karate-test-harness/actions/workflows/test.yml/badge.svg)](https://github.com/cmccarthyIrl/spring-karate-test-harness/actions/workflows/test.yml)
## Overview

The Hero Battle Application is a Spring Boot project designed to manage and simulate battles between heroes. At its core, it provides a comprehensive RESTful API for handling hero data and battle results. A key feature of this application is its robust karate test framework, which ensures the reliability and accuracy of the API by automating and streamlining the testing process. This framework supports various testing scenarios, including creating, updating, retrieving, and deleting heroes and battle results, making it an essential tool for validating the application’s functionality.
## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
  - [Hero Endpoints](#hero-endpoints)
  - [Battle Endpoints](#battle-endpoints)
  - [Results Endpoints](#results-endpoints)
- [Testing](#testing)
- [Configuration](#configuration)
- [License](#license)

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine.

### Prerequisites

- JDK 17
- Maven
- Spring Boot
- An IDE (like IntelliJ IDEA, Eclipse, or VSCode) (optional but recommended)

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/cmccarthyIrl/spring-karate-test-harness.git
   cd spring-karate-test-harness
   ```

2. **Build the project**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

3. **Run the application**

   You can run the application using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Or by running the main class directly from your IDE.

## Usage

The application exposes several RESTful endpoints. Below are the available endpoints and their usage.

### Hero Endpoints

- **List All Heroes**

  ```http
  GET /hero
  ```

  Returns a list of all heroes.

- **Get Hero by ID**

  ```http
  GET /hero/{id}
  ```

  Retrieves details of a hero by their ID.

- **Create or Update Hero**

  ```http
  POST /hero
  ```

  Request body should include the hero details in JSON format. Creates a new hero or updates an existing hero.

  Example Request Body:

  ```json
  {
    "id": 5,
    "name": "New Hero",
    "age": 30,
    "weapon": "Magic Wand",
    "specialPower": "Teleportation"
  }
  ```

- **Delete Hero by ID**

  ```http
  DELETE /hero/{id}
  ```

  Deletes a hero by their ID.

### Battle Endpoints

- **Simulate a Battle**

  ```http
  POST /battle
  ```

  Simulates a battle between two heroes. Request body should include IDs of the heroes involved.

  Example Request Body:

  ```json
  {
    "firstHeroToFight": 1,
    "secondHeroToFight": 2
  }
  ```

  Returns a battle report with a unique battle ID.

### Results Endpoints

- **Get All Results**

  ```http
  GET /results
  ```

  Retrieves a list of all battle results.

- **Get Result by ID**

  ```http
  POST /results
  ```

  Request body should include the result ID to retrieve specific battle results.

  Example Request Body:

  ```json
  {
    "resultId": 123
  }
  ```

- **Delete All Results**

  ```http
  DELETE /results
  ```

  Clears all battle results from the system.

## Testing

To run the tests, use Maven:

Note that the `mvn test` command only runs test classes that follow the `*Test.java` naming convention.

You can run a single test or a suite or tests like so :

```bash
mvn test -Dtest=HeroKarateTest
```

Note that the `mvn clean install` command runs all test Classes that follow the `*Test.java` naming convention

```bash
mvn clean install
```

Make sure to check and ensure that your tests are configured correctly and all dependencies are resolved.

## Configuration

The application uses Spring Boot's auto-configuration and embedded server setup. You can configure application settings in `src/main/resources/application.properties` or `application.yml`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.