package cmccarthyirl;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//import com.intuit.karate.KarateOptions;
//import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasses;


////To test the an existing endpoint using the Karate client un-comment the below runner
////The suite class will run in the CI with this implementation but will fail as the springApplication doesn't start
////see sure-fire in pom for disable <testFailureIgnore>
//@RunWith(Karate.class)
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
@SelectPackages({"cmccarthyirl.basic","cmccarthyirl.dynamic"})
@IncludeEngines({"junit-jupiter"})
public class JUnitSuiteTest {}