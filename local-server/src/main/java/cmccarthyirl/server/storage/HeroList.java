package cmccarthyirl.server.storage;

import cmccarthyirl.server.models.Hero;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HeroList {

    private final Map<Integer, Hero> heroMap = new HashMap<>();

    public HeroList(List<Hero> listOfHeroValues) {
        for (Hero hero : listOfHeroValues) {
            heroMap.put(hero.getId(), hero);
        }
    }

    public List<Hero> getListOfHeros() {
        return List.copyOf(heroMap.values());
    }

    public Hero getHero(int id) {
        return heroMap.get(id);
    }

    public Hero createUpdateHero(Hero newHero) {
        return heroMap.put(newHero.getId(), newHero);
    }

    public boolean deleteHero(int id) {
        return heroMap.remove(id) != null;
    }
}
