package cmccarthyirl.dynamic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "cmccarthyirl/dynamic", "cmccarthyirl/common", "cmccarthyirl/server"
})
@PropertySource("application.properties")
public class KarateContextConfiguration {
}
