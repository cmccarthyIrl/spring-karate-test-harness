package cmccarthyirl.suites;

import cmccarthyirl.basic.BasicParallelKarateTest;
import cmccarthyirl.basic.config.AbstractTestDefinition;
import cmccarthyirl.dynamic.DynamicParallelKarateTest;
import org.junit.platform.suite.api.ExcludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({DynamicParallelKarateTest.class, BasicParallelKarateTest.class})
@ExcludeEngines("junit-vintage")
public class JUnitSuiteTest extends AbstractTestDefinition {
}