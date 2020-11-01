package cmccarthyirl.models;

public class BattleRequest {
    private int firstHeroToFight;
    private int secondHeroToFight;

    public int getFirstHeroToFight() {
        return firstHeroToFight;
    }

    public void setFirstHeroToFight(int firstHeroToFight) {
        this.firstHeroToFight = firstHeroToFight;
    }

    public int getSecondHeroToFight() {
        return secondHeroToFight;
    }

    public void setSecondHeroToFight(int secondHeroToFight) {
        this.secondHeroToFight = secondHeroToFight;
    }
}