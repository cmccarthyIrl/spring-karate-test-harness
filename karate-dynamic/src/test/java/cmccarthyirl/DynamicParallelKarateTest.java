package cmccarthyirl;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

public class DynamicParallelKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate basicKarateTestAll() {
        return Karate.run("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").relativeTo(getClass());
    }
}