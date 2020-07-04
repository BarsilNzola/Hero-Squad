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
    public void tearDown() throws Exception {
    }

    @Test
    public void newHeroObject_createdCorrectly() throws Exception {
        Hero hero = new Hero("Barsil", 25, "Death Ray", "Food");
        assertEquals(true, hero instanceof Hero);
    }
}