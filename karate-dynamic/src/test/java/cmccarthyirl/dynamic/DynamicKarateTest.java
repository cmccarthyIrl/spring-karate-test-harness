package cmccarthyirl.dynamic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

import java.util.Objects;

public class DynamicKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate dynamicKarateTestAll3()  {
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/dynamic")).getPath()).tags("~@ignore");
    }
}
