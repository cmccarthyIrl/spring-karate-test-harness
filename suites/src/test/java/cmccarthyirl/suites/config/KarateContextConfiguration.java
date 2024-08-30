package cmccarthyirl.suites.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "cmccarthyirl/suites", "cmccarthyirl/basic", "cmccarthyirl/dynamic", "cmccarthyirl/common"
})
@PropertySource("application.properties")
public class KarateContextConfiguration {
}
