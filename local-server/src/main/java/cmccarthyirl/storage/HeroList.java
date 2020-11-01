package cmccarthyirl.storage;

import cmccarthyirl.models.Hero;

import java.util.List;

public class HeroList {

    private static List<Hero> listOfHeros;

    public HeroList(List<Hero> listOfHeroValues) {
        HeroList.listOfHeros = listOfHeroValues;
    }

    public static List<Hero> getListOfHeros() {
        return listOfHeros;
    }

    public static void setListOfHeros(List<Hero> listOfHeroValues) {
        HeroList.listOfHeros = listOfHeroValues;
    }

    public static Hero getHero(int id) {
        Hero anotherHero = null;
        for (Hero listOfHero : listOfHeros) {
            if (listOfHero.getId() == id) {
                anotherHero = listOfHero;
            }
        }
        return anotherHero;
    }

    public static void createUpdateHero(Hero newHero) {
        if (getHero(newHero.getId()) != null) {
            listOfHeros.remove(getHero(newHero.getId()));
        }
        listOfHeros.add(new Hero(newHero.getId(), newHero.getName(), newHero.getAge(), newHero.getWeapon(), newHero.getSpecialPower()));
    }

    public static void deleteHero(int id) {
        if (getHero(id) != null) {
            listOfHeros.remove(getHero(id));
        }
    }
}
