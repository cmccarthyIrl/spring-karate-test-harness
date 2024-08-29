package cmccarthyirl;

import cmccarthyirl.basic.BasicParallelKarateTest;
import cmccarthyirl.basic.config.AbstractTestDefinition;
import cmccarthyirl.dynamic.DynamicParallelKarateTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({DynamicParallelKarateTest.class, BasicParallelKarateTest.class})
@ExcludeEngines("junit-vintage")
public class JUnitSuiteTest extends AbstractTestDefinition {
}