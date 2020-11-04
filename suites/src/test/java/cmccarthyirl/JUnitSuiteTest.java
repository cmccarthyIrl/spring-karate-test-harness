package cmccarthyirl;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//import com.intuit.karate.KarateOptions;
//import org.junit.platform.runner.JUnitPlatform;

//import org.junit.platform.suite.api.SelectClasses;


////To test the an existing endpoint using the Karate client un-comment the below runner
////The suite class will run in the CI with this implementation but will fail as the springApplication doesn't start
////see sure-fire in pom for disable <testFailureIgnore>
//@ExtendWith(JUnitPlatform.class)
//@Suite.SuiteClasses({
//        BasicParallelKarateTest.class,
//        DynamicParallelKarateTest.class
//})
//@IncludeEngines({"junit-jupiter"})

//To test the local application we need to use JUnitPlatform Runner
//The suite class wont run in the CI with this implementation
@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
//@SelectClasses({
//        BasicParallelKarateTest.class,
//        DynamicParallelKarateTest.class
//})
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectPackages({"cmccarthyirl.basic","cmccarthyirl.dynamic"})
@IncludeEngines({"junit-jupiter"})
@ExcludeEngines({"junit-vintage"})
public class JUnitSuiteTest extends AbstractTestDefinition {

    @Test
    public void DynamicKarateTestAll() {
        Results results = Runner.path("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").parallel(1);
    }
}