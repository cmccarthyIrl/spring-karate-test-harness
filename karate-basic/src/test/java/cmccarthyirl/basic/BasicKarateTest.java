package cmccarthyirl.basic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;

public class BasicKarateTest extends AbstractTestDefinition {

//    @Test
//    public void BasicKarateTestAll() {
//        Results results = Runner.path("classpath:cmccarthyirl").parallel(1);
//    }

    @Karate.Test
    Karate basicKarateTestAll() {
        return Karate.run("classpath:cmccarthyirl/basic/").relativeTo(getClass());
    }
}
