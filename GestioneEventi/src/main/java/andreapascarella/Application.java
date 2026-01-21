package andreapascarella;


import andreapascarella.dao.EventsDAO;
import andreapascarella.entities.Event;
import andreapascarella.entities.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventipu");

    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager();
        EventsDAO ed = new EventsDAO(entityManager);

        Event concertoTheWeekend = new Event("Concerto The Weekend", LocalDate.of(2026, 6, 20), "Bellissimo", EventType.PUBLIC, 800000);
        Event partitaInter = new Event("Inter-Juventus", LocalDate.of(2026, 4, 12), "Brutto match", EventType.PRIVATE, 50000);

        //ed.save(concertoTheWeekend);
        //ed.save(partitaInter);

        System.out.println(ed.findById(2));

        ed.findByIdAndDelete(3);
    }
}
