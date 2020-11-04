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

@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
//@SelectPackages({"cmccarthyirl.basic","cmccarthyirl.dynamic"})
//@IncludeEngines({"junit-jupiter"})
//@ExcludeEngines({"junit-vintage"})
//@IncludeEngines({"junit-vintage"})
//@ExcludeEngines({"junit-jupiter"})
public class JUnitSuiteTest extends AbstractTestDefinition {

    @Test
    public void DynamicKarateTestAll() {
        Results results = Runner.path("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").parallel(1);
    }
}