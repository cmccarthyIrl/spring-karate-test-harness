package cmccarthyirl;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Karate.class)
@Suite.SuiteClasses({
        BasicParallelKarateTest.class,
        DynamicParallelKarateTest.class
})
@KarateOptions(tags = "~@ignore")
public class JUnitSuiteTest { }