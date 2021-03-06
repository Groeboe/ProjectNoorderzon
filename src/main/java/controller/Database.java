package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;
import application.*;

public class Database implements AutoCloseable {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("controller");

    public void close() {
        emf.close();
    }

    private Scanner reader;


    /**
     * De verbinding om het totale programma te tonen
     *
     */
    public Voorstelling showAlleVoorstellingen() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Voorstelling> q = em.createQuery(
                    "SELECT v FROM Entities.Voorstelling v WHERE v.genre = :genre", Voorstelling.class);
            Voorstelling.class);
            q.setParameter("naamvanartiest", artiest.getNaam());
            for (Voorstelling v : q.getResultList()) {
                return v.getDetails(); // uitzoeken hoe die methode heet
            }
        } finally {
            em.close();
        }
    }

    /**
     * hier moet de artiest opgehaald worden uit het webformulier
     * daarna moeten de voorstellingen met die artiest worden teruggegeven aan de front-end
     * mv
     */
    public Voorstelling zoekVoorstellingOpArtiest(Artiest artiest) {
		EntityManager em = emf.createEntityManager();
		try {
        	TypedQuery<Voorstelling> q = em.createQuery(
                "SELECT v FROM Entities.Voorstelling v WHERE v.artiest HAVING :naamvanartiest",
                Voorstelling.class);
        q.setParameter("naamvanartiest", artiest.getNaam());
        for (Voorstelling v : q.getResultList()) {
            return v.getDetails(); // uitzoeken hoe die methode heet
        }
		} finally {
			em.close();
		}
		}

    /**
     * hier moet de naam van de voorstelling opgehaald worden uit het webformulier
     * daarna moeten de voorstellingen met die naam worden teruggegeven aan de front-end
     * mv
     */
    public Voorstelling zoekVoorstellingOpNaam(String zoekNaam) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Voorstelling> q = em.createQuery(
                    "SELECT v FROM Entities.Voorstelling v WHERE v.name CONTAINS :deelvannaam", Voorstelling.class);
                    Voorstelling.class);
            q.setParameter("naamvanartiest", artiest.getNaam());
            for (Voorstelling v : q.getResultList()) {
                return v.getDetails(); // uitzoeken hoe die methode heet
            }
        } finally {
            em.close();
        }
    }

    /**
     * hier moet het genre van de voorstelling opgehaald worden uit het webformulier
     * daarna moeten de voorstellingen in dat genre worden teruggegeven aan de front-end
     * mv
     */
    public Voorstelling zoekVoorstellingOpGenre(Genre) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Voorstelling> q = em.createQuery(
                    "SELECT v FROM Entities.Voorstelling v WHERE v.genre = :genre", Voorstelling.class);
            Voorstelling.class);
            q.setParameter("naamvanartiest", artiest.getNaam());
            for (Voorstelling v : q.getResultList()) {
                return v.getDetails(); // uitzoeken hoe die methode heet
            }
        } finally {
            em.close();
        }
    }



}