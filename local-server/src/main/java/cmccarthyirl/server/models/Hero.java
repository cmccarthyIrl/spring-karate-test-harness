package cmccarthyirl.server.models;

public class Hero {
    int age;
    private int id;
    private String name;
    private String weapon;
    private String specialPower;

    public Hero(int id, String name, int age, String weapon, String specialPower) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weapon = weapon;
        this.specialPower = specialPower;
    }

    public Hero(int incrementAndGet) {
        this.id = incrementAndGet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}