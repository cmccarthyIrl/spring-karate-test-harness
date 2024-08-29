package cmccarthyirl.robot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "cmccarthyirl/robot",  "cmccarthyirl/common",
})
@PropertySource("application.properties")
public class KarateContextConfiguration {
}
