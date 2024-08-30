package cmccarthyirl.basic;

import cmccarthyirl.basic.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

public class BasicParallelKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate e2eKarateTest() {
        return Karate.run("E2ETest").relativeTo(getClass()).tags("~@ignore");
    }
}