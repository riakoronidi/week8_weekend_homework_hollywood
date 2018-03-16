import db.DBHelper;
import models.Agent;
import models.Director;
import models.Film;
import models.Studio;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Paramount Pictures", "Los Angeles", 25000000);
        Studio studio2 = new Studio("20th Century Fox", "Los Angeles", 50000000);
        DBHelper.saveOrUpdate(studio1);
        DBHelper.saveOrUpdate(studio2);


        Film film1 = new Film("Life is Beautiful","Drama", 116, 20000000, studio2);
        Film film2 = new Film("The Lion King","Animation", 88, 45000000, studio2);
        Film film3 = new Film("The Godfather","Crime", 175, 6000000, studio2);
        Film film4 = new Film("Lord of the Rings: The Fellowship of the Ring","Fantasy", 178, 93000000, studio1);
        Film film5 = new Film("Murder on the Orient Express ","Crime", 114, 55000000, studio1);

        DBHelper.saveOrUpdate(film1);
        DBHelper.saveOrUpdate(film2);
        DBHelper.saveOrUpdate(film3);
        DBHelper.saveOrUpdate(film4);
        DBHelper.saveOrUpdate(film5);


        Agent agent1 = new Agent("Estelle");
        DBHelper.saveOrUpdate(agent1);

        Director director1 = new Director("Kenneth", 100, agent1);
        Director director2 = new Director("Julia", 100, agent1);
        DBHelper.saveOrUpdate(director1);
        DBHelper.saveOrUpdate(director2);


    }
}
