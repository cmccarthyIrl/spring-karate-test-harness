package cmccarthyirl.dynamic.config;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {KarateContextConfiguration.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbstractTestDefinition {

    @LocalServerPort
    protected int port;

    @BeforeEach
    public void setUp() {
        System.setProperty("karate.baseUrl", "http://localhost:" + port);
    }
}