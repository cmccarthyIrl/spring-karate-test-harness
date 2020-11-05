package cmccarthyirl.dynamic;

import cmccarthyirl.config.AbstractTestDefinition;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

public class DynamicKarateTest extends AbstractTestDefinition {

//    @Test
//    public void DynamicKarateTestAll() {
//        Results results = Runner.path("classpath:c").parallel(1);
//    }        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/basic")).getPath());

    @Karate.Test
    Karate dynamicKarateTestAll() throws IOException {
//        return Karate.run("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").relativeTo(getClass());
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/dynamic/ReUseFeaturesTests.feature")).getFile());
    }

    @Karate.Test
    Karate dynamicKarateTestAll2() throws IOException {
//        return Karate.run("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").relativeTo(getClass());
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/dynamic/ReUseFeaturesTests.feature")).getPath());
    }

    @Karate.Test
    Karate dynamicKarateTestAll3() throws IOException {
//        return Karate.run("classpath:cmccarthyirl/dynamic/ReUseFeaturesTests.feature").relativeTo(getClass());
        return Karate.run(Objects.requireNonNull(getClass().getClassLoader().getResource("cmccarthyirl/dynamic")).getPath());
    }
}
