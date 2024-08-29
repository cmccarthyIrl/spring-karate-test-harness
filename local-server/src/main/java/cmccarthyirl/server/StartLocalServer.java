package cmccarthyirl.server;

import cmccarthyirl.server.models.Hero;
import cmccarthyirl.server.storage.HeroList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartLocalServer {

    @Autowired
    private HeroList heroList;

    public static void main(String[] args) {
        SpringApplication.run(StartLocalServer.class, args);
    }

    @PostConstruct
    public void init() {
        try {
            List<Hero> list = createInitialHeroes();
            for (Hero hero : list) {
                heroList.createUpdateHero(hero);
            }
        } catch (Exception ex) {
            // Replace with proper logging
            ex.printStackTrace();
        }
    }

    private List<Hero> createInitialHeroes() {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero(1, "Achilles", 27, "Sword & Shield", "Super speed"));
        list.add(new Hero(2, "Spartacus", 55, "Sword", "Incredible strength"));
        list.add(new Hero(3, "Bruce Lee", 100, "Fists", "Super fast"));
        list.add(new Hero(4, "Dead Pool", 1000, "Guns", "Can't die"));
        return list;
    }
}
