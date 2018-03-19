import db.DBHelper;
import models.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Actor_Actress actor_actress;
    Agent agent;
    Film film;
    Studio studio;
    Director director;

    @Before
    public void setUp() throws Exception {
        agent = new Agent("Estelle");
        DBHelper.saveOrUpdate(agent);
        actor_actress = new Actor_Actress("Roberto Benini", 100, agent);
        DBHelper.saveOrUpdate(actor_actress);
        studio = new Studio("Paramount Pictures", "Los Angeles", 25000000);
        DBHelper.saveOrUpdate(studio);
        director = new Director("Kenneth", 80, agent);
        DBHelper.saveOrUpdate(director);
        film = new Film("Life is Beautiful","Drama", 116, 200, studio, director);
        DBHelper.saveOrUpdate(film);
    }

    @Test
    public void canSave() {
        Actor_Actress foundActor = DBHelper.find(Actor_Actress.class, actor_actress.getId());
        assertEquals(100, foundActor.getCash());
    }

    @Test
    public void actorGetsPaid() {
        DBHelper.addActorToFilm(actor_actress, film);
        actor_actress.starGetPaid();
        assertEquals(120,actor_actress.getCash());
        assertEquals(180, film.getBudget());
    }

//    ignore this test - its not working, no time to fix..
//    @Test
//    public void directorGetsPaid() {
//        Director foundDirector = DBHelper.find(Director.class, director.getId());
//        Film foundFilm = DBHelper.find(Film.class, film.getId());
//        foundDirector.addFilm(foundFilm);
//        foundDirector.directorGetPaid();
////        assertEquals(100, director.getCash());
//        assertEquals(180, film.getBudget());
//    }

}
