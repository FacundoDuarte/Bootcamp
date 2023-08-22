package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Event;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.repositories.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event currentEvent, Event newEvent) {
        currentEvent.setName(newEvent.getName());
        currentEvent.setEventDate(newEvent.getEventDate());
        currentEvent.setLocation(newEvent.getLocation());
        currentEvent.setState(newEvent.getState());
        return eventRepository.save(currentEvent);
    }

    public Event findEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }

    public List<Event> allEvents(User currentUser) {
        List<Event> events = eventRepository.findAll();
        for (Event event : events) {
            event.setJoinedByCurrentUser(event.isJoinedByUser(currentUser));
        }
        return events;
    }

    public List<Event> allEventsByState(Long userId) {
        return eventRepository.findByUserState(userId);
    }
}
