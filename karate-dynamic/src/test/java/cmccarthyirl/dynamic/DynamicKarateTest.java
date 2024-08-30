package cmccarthyirl.dynamic;

import cmccarthyirl.dynamic.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

import java.util.Objects;

public class DynamicKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate dynamicKarateTest() {
        return (Karate) Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/dynamic")).getPath()).tags("~@ignore");
    }
}
