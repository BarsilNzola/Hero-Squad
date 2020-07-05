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
}