package db;

import models.Actor_Actress;
import models.Director;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static <T> T getUnique(Criteria criteria) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //find unique by ID
    public static <T> T find(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classType);
        criteria.add(Restrictions.idEq(id));
        result = getUnique(criteria);
        return result;
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

    public static List<Film> getFilmByDirector(Director director) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;
        Criteria cr = session.createCriteria(Film.class);
        cr.add(Restrictions.eq("director", director));
//        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        results = getList(cr);
        return results;
    }


    public static void addActorToFilm(Actor_Actress actor_actress, Film film) {
        actor_actress.addFilm(film);
        film.addStar(actor_actress);
        saveOrUpdate(actor_actress);
        saveOrUpdate(film);
    }


    public static List<Film> getFilmByActorAndGenre(Actor_Actress actor_actress, String genre) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;
        Criteria cr = session.createCriteria(Film.class);
        Criteria cr2 = session.createCriteria(Film.class);
        cr.add(Restrictions.eq("actors_actresses", actor_actress));
//        cr2.add(Restrictions.eq("genre", genre));
//        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        results = getList(cr);
        return results;
    }

}

