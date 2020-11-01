package cmccarthyirl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "cmccarthyirl"
})
@PropertySource("classpath:/application.properties")
public class KarateContextConfiguration {
}
