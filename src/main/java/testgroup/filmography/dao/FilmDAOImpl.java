package testgroup.filmography.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO {
//    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
//    private static Map<Integer, Film> films = new HashMap<>();
    private SessionFactory sessionFactory;
//    static {
//        Film film1 = new Film();
//        film1.setId(AUTO_ID.getAndIncrement());
//        film1.setTitle("Inception");
//        film1.setYear(2010);
//        film1.setGenre("sci-fi");
//        film1.setWatched(true);
//        films.put(film1.getId(), film1);
//        // + film2, film3, film4, ...    }
//    }
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Film> allFilms(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").setFirstResult(10*(page-1)).
                setMaxResults(10).list();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Film> allFilms() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from Film").list();
//    }

    @Override
    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    @SuppressWarnings("unchecked")
    public int filmsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Film", Number.class).getSingleResult().intValue();
    }
}
