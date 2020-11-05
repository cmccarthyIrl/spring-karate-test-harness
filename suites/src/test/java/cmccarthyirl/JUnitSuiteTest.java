package cmccarthyirl;

import cmccarthyirl.basic.BasicKarateTest;
import cmccarthyirl.config.AbstractTestDefinition;
import cmccarthyirl.dynamic.DynamicKarateTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({DynamicKarateTest.class, BasicKarateTest.class})
@SelectClasses({DynamicParallelKarateTest.class, BasicParallelKarateTest.class})
@ExcludeEngines("junit-vintage")
public class JUnitSuiteTest extends AbstractTestDefinition {
}