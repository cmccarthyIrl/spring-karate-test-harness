package cmccarthyirl;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

public class BasicParallelKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate basicKarateTestAll() {
        return Karate.run("classpath:cmccarthyirl/basic").relativeTo(getClass());
    }
}