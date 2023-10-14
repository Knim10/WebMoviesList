package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Movie;
import model.MovieNight;

public class MovieNightHelper {

    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebMovieNightList");

    public void insertMovieNight(MovieNight mn) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(mn);
        em.getTransaction().commit();
        em.close();
    }

    public List<MovieNight> showAllMovieNights() {
        EntityManager em = emfactory.createEntityManager();
        List<MovieNight> allMovieNights = em.createQuery("SELECT m FROM MovieNight m").getResultList();
        return allMovieNights;
    }

    public MovieNight searchForMovieNightById(int idToEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        MovieNight found = em.find(MovieNight.class, idToEdit);
        em.close();
        return found;
    }
    
    public void addMovieToMovieNight(Movie movie, MovieNight movieNight) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        movie = em.find(Movie.class, movie.getId());
        movieNight = em.find(MovieNight.class, movieNight.getId());

        movie.setMovieNight(movieNight);  
        em.merge(movie);  

        em.getTransaction().commit();
        em.close();
    }
    
    public void deleteMovieNight(MovieNight movieNight) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        MovieNight toDelete = em.find(MovieNight.class, movieNight.getId());
        if (toDelete != null) {
            em.remove(toDelete);
        }
        em.getTransaction().commit();
        em.close();
    }
}