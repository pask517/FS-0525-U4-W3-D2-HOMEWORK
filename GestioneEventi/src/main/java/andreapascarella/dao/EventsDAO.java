package andreapascarella.dao;

import andreapascarella.entities.Event;
import andreapascarella.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {

    private EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newEvent);

        transaction.commit();

        System.out.println("L'evento " + newEvent.getTitle() + " é stato salvato correttamente");
    }

    public Event findById(long eventId) {
        Event found = entityManager.find(Event.class, eventId);
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }

    public void findByIdAndDelete(long eventId) {
        Event foundEvent = this.findById(eventId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(foundEvent);
        transaction.commit();
        System.out.println("L'evento con id:" + eventId + " é stato rimosso correttamente");
    }
}
