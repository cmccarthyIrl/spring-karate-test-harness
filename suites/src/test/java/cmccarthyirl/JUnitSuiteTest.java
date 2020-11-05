package cmccarthyirl;

import cmccarthyirl.basic.BasicKarateTest;
import cmccarthyirl.config.AbstractTestDefinition;
import cmccarthyirl.dynamic.DynamicKarateTest;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit5.Karate;
//import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;

//@KarateOptions(tags = "~@ignore")
@RunWith(JUnitPlatform.class)
@SelectClasses({DynamicKarateTest.class, BasicKarateTest.class})
public class JUnitSuiteTest extends AbstractTestDefinition {
}