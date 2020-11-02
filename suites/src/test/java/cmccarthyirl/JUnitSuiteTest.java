package cmccarthyirl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BasicParallelKarateTest.class,
        DynamicParallelKarateTest.class
})
//@ExcludeEngines("junit-vintage")
//@IncludeEngines("junit-jupiter")
public class JUnitSuiteTest {}