package management.prayerhouse.system.service;



import management.prayerhouse.system.entity.Event;
import management.prayerhouse.system.repository.EventRepository;
import management.prayerhouse.system.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event updateEvent(Long id, Event event) {

        Event existingEvent = eventRepository.findById(id).orElse(null);

        if (existingEvent == null) {
            return null;
        }

        existingEvent.setTitle(event.getTitle());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setEventDate(event.getEventDate());
        existingEvent.setEventTime(event.getEventTime());

        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getTodayEvents() {
        return eventRepository.findByEventDate(LocalDate.now());
    }
}