package com.imran.eventplatform;
import com.imran.eventplatform.model.Event;
import com.imran.eventplatform.exception.EventNotFoundException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event(1L, "Java Workshop", "Chennai", 50));
        events.add(new Event(3L, "Spring Boot Event", "Bangalore", 350));

        System.out.println("Total events: " + events.size());

        try {
            Event found = findEventById(events, 3L);
            found.printSummary();

            findEventById(events, 4L);

        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Event findEventById(ArrayList<Event> events, Long id) {

        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }

        throw new EventNotFoundException(
                "Event with ID " + id + " not found"
        );
    }
}