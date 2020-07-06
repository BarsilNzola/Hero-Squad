package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void newSquadObjectCreatedSuccessfully(){
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void newSquadObject_getsSquadName() {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        assertEquals("The Saturdays", squad.getName());
    }

    @Test
    public void newSquadObject_getsSquadCause() {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        assertEquals("Bring Light to the Dark", squad.getCause());
    }

    @Test
    public void newSquadObject_getsSquadSize() {
        Squad squad = new Squad("The Saturdays", "Bring Light to the Dark", 5);
        assertEquals(5, squad.getsquadSize());
    }
}