package dao;

import models.Hero;
import java.util.List;

public interface HeroDao {

    //LIST
    List<Hero> getAll();

    //CREATE
    void add(Hero hero);

    //READ
    Hero findById(int id);

    //DELETE
    void deleteById(int id);
    void clearAllHeroes();
}
