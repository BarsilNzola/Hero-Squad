package dao;

import models.Hero;
import models.Squad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oSquadDaoTest {
    private Sql2oSquadDao squadDao;
    private Sql2oHeroDao heroDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        squadDao = new Sql2oSquadDao(sql2o);
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingSquadSetsId() throws Exception {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        int originalSquadId = squad.getId();
        squadDao.add(squad);
        assertNotEquals(originalSquadId, squad.getId());
    }

    @Test
    public void existingSquadsCanBeFoundById() throws Exception {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        squadDao.add(squad);
        Squad foundSquad = squadDao.findById(squad.getId());
        assertEquals(squad, foundSquad);
    }

    @Test
    public void addedSquadsAreReturnedFromGetAll() throws Exception {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        squadDao.add(squad);
        assertEquals(1, squadDao.getAll().size());
    }

    @Test
    public void noSquadsReturnsEmptyList() throws Exception {
        assertEquals(0, squadDao.getAll().size());
    }

    @Test
    public void updateChangesSquadContent() throws Exception {
        String initialSquadName = "The Saturdays";
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        squadDao.add(squad);
        squadDao.update(squad.getId(),"TMNT", "Stop Krang Invasion", 4);
        Squad updatedSquad = squadDao.findById(squad.getId());
        assertNotEquals(initialSquadName, updatedSquad.getName());
    }

    @Test
    public void deleteByIdDeletesCorrectSquad() throws Exception {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        squadDao.add(squad);
        squadDao.deleteById(squad.getId());
        assertEquals(0, squadDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllSquads() throws Exception {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        Squad otherSquad = new Squad("TMNT", "Stop Krang Invasion", 4);
        squadDao.add(squad);
        squadDao.add(otherSquad);
        int daoSize = squadDao.getAll().size();
        squadDao.clearAllSquads();
        assertTrue(daoSize > 0 && daoSize > squadDao.getAll().size());
    }

    @Test
    public void getAllHeroesBySquadReturnsTasksCorrectly() throws Exception {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        squadDao.add(squad);
        int squadId = squad.getId();
        Hero newHero = new Hero("Michaelangelo", "Mikey", 16, "Skateboard", "Pizza", squadId);
        Hero otherHero = new Hero("Raphael","Raph", 16, "Strength", "Cockroach", squadId);
        Hero thirdHero = new Hero("Donatelo", "Donnie", 16, "Smart", "April", squadId);
        heroDao.add(newHero);
        heroDao.add(otherHero); //we are not adding task 3 so we can test things precisely.
        assertEquals(2, squadDao.getAllHeroesBySquad(squadId).size());
        assertTrue(squadDao.getAllHeroesBySquad(squadId).contains(newHero));
        assertTrue(squadDao.getAllHeroesBySquad(squadId).contains(otherHero));
        assertFalse(squadDao.getAllHeroesBySquad(squadId).contains(thirdHero)); //things are accurate!
    }
}