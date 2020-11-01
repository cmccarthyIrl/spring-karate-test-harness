package cmccarthyirl.dynamic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

public class DynamicKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate DynamicKarateTestAll() {
        return Karate.run("ReUseFeaturesTests.feature").relativeTo(getClass());
    }
}
