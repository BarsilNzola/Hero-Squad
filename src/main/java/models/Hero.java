package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private String name;
    private String nickname;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private int squadId;

    public Hero(String name,String nickname, int age, String power, String weakness, int squadId){
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.squadId = squadId;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
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


    public int getId() {
        return id;
    }
}
