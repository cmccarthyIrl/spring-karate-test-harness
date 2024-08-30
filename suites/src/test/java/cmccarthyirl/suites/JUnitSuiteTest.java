package cmccarthyirl.suites;

import cmccarthyirl.basic.BasicParallelKarateTest;
import cmccarthyirl.basic.config.AbstractTestDefinition;
import cmccarthyirl.dynamic.DynamicParallelKarateTest;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({DynamicParallelKarateTest.class, BasicParallelKarateTest.class})
public class JUnitSuiteTest extends AbstractTestDefinition {
}