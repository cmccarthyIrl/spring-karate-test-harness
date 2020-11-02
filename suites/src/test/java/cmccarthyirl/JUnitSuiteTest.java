package cmccarthyirl;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Karate.class)
@Suite.SuiteClasses({
        BasicParallelKarateTest.class,
        DynamicParallelKarateTest.class
})
@KarateOptions(tags = "~@ignore")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JUnitSuiteTest { }