package cmccarthyirl.robot;

import cmccarthyirl.robot.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;
import java.util.Objects;

public class CalculatorRunner extends AbstractTestDefinition {

    @Karate.Test
    Karate robotKarateTestAll() {
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/robot")).getPath());
    }
}


