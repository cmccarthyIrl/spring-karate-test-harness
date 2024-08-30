package cmccarthyirl.basic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "cmccarthyirl/basic", "cmccarthyirl/common", "cmccarthyirl/server"
})
@PropertySource("application.properties")
public class KarateContextConfiguration {
}
