package cmccarthyirl;

import com.intuit.karate.KarateOptions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
@SelectClasses({
        BasicParallelKarateTest.class,
        DynamicParallelKarateTest.class
})
@IncludeEngines({"junit-jupiter","junit-vintage"})
public class JUnitSuiteTest {}