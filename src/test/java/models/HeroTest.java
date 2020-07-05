package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
        Hero.clearAllHeroes();
    }

    @Test
    public void newHeroObject_createdCorrectly() throws Exception {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void newHeroObject_getsHeroName() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals("Barsil", hero.getName());
    }

    @Test
    public void newHeroObject_getsHeroNickName() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals("The Forever Knights", hero.getNickname());
    }

    @Test
    public void newHeroObject_getsHeroAge() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals(25, hero.getAge());
    }

    @Test
    public void newHeroObject_getsHeroPower() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals("Death Ray", hero.getPower());
    }

    @Test
    public void newHeroObject_getsHeroWeakness() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals("Food", hero.getWeakness());
    }

    @Test
    public void newHeroObject_allHeroesAreCorrectlyReturned() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        Hero otherHero = new Hero("Adrian", "Ngwala", 7, "Super Speed", "Sleep");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void newHeroObject_allHeroesContainAllHeroes_true() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        Hero otherHero = new Hero("Adrian", "Ngwala", 7, "Super Speed", "Sleep");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getId_heroesInstantiatesWithAnID() throws Exception {
        Hero.clearAllHeroes();
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals(1, hero.getId());
    }

    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectHero_moreThanOneHero() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        Hero otherHero = new Hero("Adrian", "Ngwala", 7, "Super Speed", "Sleep");
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }

    @Test
    public void heroDeletion_deleteHero() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        Hero otherHero = new Hero("Adrian", "Ngwala", 7, "Super Speed", "Sleep");
        hero.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(),2);
    }

    @Test
    public void allHeroesDeletion_clearAllHeroes() {
        Hero hero = new Hero("Barsil", "The Forever Knights", 25, "Death Ray", "Food");
        Hero otherHero = new Hero("Adrian", "Ngwala", 7, "Super Speed", "Sleep");
        Hero.clearAllHeroes();
        assertEquals(0,Hero.getAll().size());
    }
}