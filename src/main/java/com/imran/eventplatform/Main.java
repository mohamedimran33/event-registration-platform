
package com.imran.eventplatform;

import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;
import com.imran.eventplatform.service.EventService;

public class Main {

    public static void main(String[] args) {

        // 1. Create the event service
        EventService service = new EventService();

        // 2. Register events
        service.addEvent(new Event(
                1L, "Chai Startups Meetup", "Bangalore", 100
        ));

        service.addEvent(new Event(
                2L, "Tech Meetup", "Bangalore", 80
        ));

        // 3. Display total registered events
        System.out.println("Total events: " + service.getTotalEvents());

        // 4. Search for an existing event
        try {
            Event found = service.searchEventById(2L);
            found.printSummary();
        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Handle an event that does not exist
        try {
            service.searchEventById(999L);
        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
