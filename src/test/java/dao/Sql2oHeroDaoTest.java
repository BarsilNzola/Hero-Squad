package dao;

import models.Hero;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oHeroDaoTest {
    private static Sql2oHeroDao heroDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/herosquad_test";
        Sql2o sql2o = new Sql2o(connectionString, "barsil", "madboysent7042");
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        heroDao.clearAllHeroes();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void addingHeroSetsId() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food", 1);
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void addedHeroesAreReturnedFromgetAll() throws Exception {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food", 1);
        heroDao.add(hero);
        assertEquals(1, heroDao.getAll().size());
    }

    @Test
    public void existingHeroesCanBeFoundById() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food", 1);
        heroDao.add(hero);
        Hero foundHero = heroDao.findById(hero.getId());
        assertEquals(hero, foundHero);
    }

    @Test
    public void deleteByIdDeletesHero() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food", 1);
        heroDao.add(hero);
        heroDao.deleteById(hero.getId());
        assertEquals(0,heroDao.getAll().size());
    }

    @Test
    public void clearAllclearsAllHeroes() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food", 1);
        Hero otherHero = new Hero("Adrian", "Ngwala", 7, "Super Speed", "Sleep", 2);
        heroDao.add(hero);
        heroDao.add(otherHero);
        int daoSize = heroDao.getAll().size();
        heroDao.clearAllHeroes();
        assertTrue(daoSize > 0 && daoSize > heroDao.getAll().size());
    }

    @Test
    public void squadIdIsReturnedCorrectly() throws Exception {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food", 1);
        int originalSquadId = hero.getSquadId();
        heroDao.add(hero);
        assertEquals(originalSquadId, heroDao.findById(hero.getId()).getSquadId());
    }
}