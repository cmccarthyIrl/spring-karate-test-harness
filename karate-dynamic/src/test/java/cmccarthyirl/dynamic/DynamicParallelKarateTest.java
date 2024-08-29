package cmccarthyirl.dynamic;

import cmccarthyirl.dynamic.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

import java.util.Objects;

public class DynamicParallelKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate dynamicKarateTestAll() {
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/dynamic")).getPath()).tags("~@ignore");
    }
}