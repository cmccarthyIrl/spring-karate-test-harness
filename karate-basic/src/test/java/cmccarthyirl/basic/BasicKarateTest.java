package cmccarthyirl.basic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

import java.util.Objects;

public class BasicKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate basicKarateTestAll() {
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/basic")).getPath());
    }
}
