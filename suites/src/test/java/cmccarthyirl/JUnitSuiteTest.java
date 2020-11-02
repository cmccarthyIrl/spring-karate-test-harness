package cmccarthyirl;

import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeEngines;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        BasicParallelKarateTest.class,
        DynamicParallelKarateTest.class
})
//@ExcludeEngines("junit-vintage")
//@IncludeEngines("junit-jupiter")
//@IncludeEngines({"junit-jupiter","junit-vintage"})
public class JUnitSuiteTest {
    @Test
    public void foo(){}
}