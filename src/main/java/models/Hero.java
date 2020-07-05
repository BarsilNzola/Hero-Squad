package models;

import java.util.ArrayList;

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
