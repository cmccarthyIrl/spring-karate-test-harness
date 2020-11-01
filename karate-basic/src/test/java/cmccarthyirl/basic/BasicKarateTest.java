package cmccarthyirl.basic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.junit5.Karate;

public class BasicKarateTest extends AbstractTestDefinition {

    @Karate.Test
    Karate BasicKarateTestAll() {
        return Karate.run().relativeTo(getClass());
    }
}
