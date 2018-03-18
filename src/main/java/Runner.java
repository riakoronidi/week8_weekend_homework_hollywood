import db.DBHelper;
import models.*;
import sun.tools.jstat.Literal;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Paramount Pictures", "Los Angeles", 25000000);
        Studio studio2 = new Studio("20th Century Fox", "Los Angeles", 50000000);
        DBHelper.saveOrUpdate(studio1);
        DBHelper.saveOrUpdate(studio2);

        Agent agent1 = new Agent("Estelle");
        DBHelper.saveOrUpdate(agent1);

        Director director1 = new Director("Kenneth", 100, agent1);
        Director director2 = new Director("Julia", 100, agent1);
        DBHelper.saveOrUpdate(director1);
        DBHelper.saveOrUpdate(director2);

        Actor_Actress actor1 = new Actor_Actress("Roberto Benini", 100, agent1);
        Actor_Actress actor2 = new Actor_Actress("Johnny Depp", 150, agent1);
        Actor_Actress actress1 = new Actor_Actress("Penelope Cruz", 200, agent1);
        Actor_Actress actress2 = new Actor_Actress("Judi Dench", 250, agent1);
        DBHelper.saveOrUpdate(actor1);
        DBHelper.saveOrUpdate(actor2);
        DBHelper.saveOrUpdate(actress1);
        DBHelper.saveOrUpdate(actress2);

        Film film1 = new Film("Life is Beautiful","Drama", 116, 20000000, studio2, director1);
        Film film2 = new Film("The Lion King","Animation", 88, 45000000, studio2, director2);
        Film film3 = new Film("The Godfather","Crime", 175, 6000000, studio2, director1);
        Film film4 = new Film("Lord of the Rings: The Fellowship of the Ring","Fantasy", 178, 93000000, studio1, director1);
        Film film5 = new Film("Murder on the Orient Express ","Drama", 114, 55000000, studio1, director1);

        DBHelper.saveOrUpdate(film1);
        DBHelper.saveOrUpdate(film2);
        DBHelper.saveOrUpdate(film3);
        DBHelper.saveOrUpdate(film4);
        DBHelper.saveOrUpdate(film5);


        Film foundFilm = DBHelper.find(Film.class, film3.getId());

        List<Film> ListOfFilmsByDirector = DBHelper.getFilmByDirector(director1);

        DBHelper.addActorToFilm(actor1, film5);
        DBHelper.addActorToFilm(actor1, film1);
        DBHelper.addActorToFilm(actor2, film1);
        Actor_Actress foundFilmsByStar = DBHelper.find(Actor_Actress.class, actor1.getId());
        Film foundStarsByFilm = DBHelper.find(Film.class, film1.getId());


//        List<Film> found = DBHelper.getFilmByActorAndGenre(actor1,film1.getGenre());

    }
}
