package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private String name;
    private String nickname;
    private int age;
    private String power;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private int id;

    public Hero(String name,String nickname, int age, String power, String weakness){
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                name.equals(hero.name) &&
                nickname.equals(hero.nickname) &&
                power.equals(hero.power) &&
                weakness.equals(hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, age, power, weakness, id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public String getNickname(){
        return this.nickname;
    }

    public int getAge(){
        return this.age;
    }

    public String getPower(){
        return this.power;
    }

    public String getWeakness(){
        return this.weakness;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void clearAllHeroes(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Hero findById(int id){
        return instances.get(id-1);
    }


    public void deleteHero() {
        instances.remove(id-1);
    }
}
