package cmccarthyirl;

import cmccarthyirl.basic.BasicKarateTest;
import cmccarthyirl.config.AbstractTestDefinition;
import cmccarthyirl.dynamic.DynamicKarateTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

//@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
@SelectClasses({DynamicKarateTest.class, BasicKarateTest.class})
public class JUnitSuiteTest extends AbstractTestDefinition {
}