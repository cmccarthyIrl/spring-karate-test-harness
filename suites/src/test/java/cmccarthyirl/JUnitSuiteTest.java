package cmccarthyirl;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.intuit.karate.KarateOptions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasses;


//To test the an existing endpoint using the Karate client un-comment the below runner
//@RunWith(Karate.class)
//@Suite.SuiteClasses({
//        BasicParallelKarateTest.class,
//        DynamicParallelKarateTest.class
//})

//To test the local application we need to use JUnitPlatform Runner
@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
@SelectClasses({
        BasicParallelKarateTest.class,
        DynamicParallelKarateTest.class
})
@IncludeEngines({"junit-jupiter"})
public class JUnitSuiteTest {}