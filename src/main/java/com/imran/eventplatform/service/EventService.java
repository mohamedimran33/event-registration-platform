
package com.imran.eventplatform.service;

import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;

import java.util.HashMap;
import java.util.Map;

public class EventService {

    // Store events using their IDs as keys
    private final Map<Long, Event> events = new HashMap<>();

    // CREATE - Add an event and prevent duplicate IDs
    public void addEvent(Event event) {
        if (events.containsKey(event.getId())) {
            throw new IllegalArgumentException("ID already present");
        }

        events.put(event.getId(), event);
    }

    // READ - Return the total number of events
    public int getTotalEvents() {
        return events.size();
    }

    // READ - Find an event by ID
    public Event searchEventById(Long id) {
        Event event = events.get(id);

        if (event == null) {
            throw new EventNotFoundException(
                    "Event with ID " + id + " not found"
            );
        }

        return event;
    }

    // DELETE - Remove an event by ID
    public boolean deleteEvent(Long id) {
        return events.remove(id) != null;
    }

    // UPDATE - Change an event's venue
    public void updateEventVenue(Long id, String newVenue) {
        Event event = searchEventById(id);
        event.updateVenue(newVenue);
    }

    // UPDATE - Change an event's capacity
    public void updateEventCapacity(Long id, int newCapacity) {
        Event event = searchEventById(id);
        event.updateCapacity(newCapacity);
    }
}
