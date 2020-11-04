package cmccarthyirl.dynamic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;

public class DynamicKarateTest extends AbstractTestDefinition {

//    @Test
//    public void DynamicKarateTestAll() {
//        Results results = Runner.path("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").parallel(1);
//    }

    @Karate.Test
    Karate basicKarateTestAll() {
        return Karate.run("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").relativeTo(getClass());
    }
}
