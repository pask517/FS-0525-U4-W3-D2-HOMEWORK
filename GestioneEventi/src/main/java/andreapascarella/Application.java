package andreapascarella;


import andreapascarella.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventipu");

    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager();

        Event concertoTheWeekend = new Event("Concerto The Weekend", LocalDate.of(2026, 6, 20), "Bellissimo", 800000);

    }
}
