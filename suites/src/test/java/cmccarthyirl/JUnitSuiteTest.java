package cmccarthyirl;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit5.Karate;
//import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;

@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
//@SelectPackages({"cmccarthyirl.basic","cmccarthyirl.dynamic"})
//@IncludeEngines({"junit-jupiter"})
//@ExcludeEngines({"junit-vintage"})
//@IncludeEngines({"junit-vintage"})
//@ExcludeEngines({"junit-jupiter"})
public class JUnitSuiteTest extends AbstractTestDefinition {


    @Karate.Test
    Karate dynamicKarateTestFeature() {
        return Karate.run("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").relativeTo(getClass());
    }

    @Karate.Test
    Karate basicKarateTestAll() {
        return Karate.run("classpath:cmccarthyirl/basic").relativeTo(getClass());
    }

//    @Test
//    public void DynamicKarateTestAll() {
//
//        Results results = Runner.path("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").parallel(1);
//    }
}