package cmccarthyirl.dynamic;

import cmccarthyirl.dynamic.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

public class DynamicParallelKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate reuseKarateTest() {
        return Karate.run("ReUseFeaturesTests").relativeTo(getClass()).tags("~@ignore");
    }
}