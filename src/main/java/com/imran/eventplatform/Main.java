
package com.imran.eventplatform;

import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;
import com.imran.eventplatform.service.EventService;

public class Main {

    public static void main(String[] args) {

        // 1. CREATE EVENT SERVICE
        EventService service = new EventService();

        // 2. CREATE EVENTS
        service.addEvent(new Event(1L, "Chai Startups Meetup", "Bangalore", 100));
        service.addEvent(new Event(2L, "Tech Meetup", "Bangalore", 80));

        System.out.println("Total events: " + service.getTotalEvents());

        // 3. READ - SEARCH FOR AN EXISTING EVENT
        try {
            Event found = service.searchEventById(2L);
            found.printSummary();
        } catch (EventNotFoundException e) {
            System.out.println("Search error: " + e.getMessage());
        }

        // 4. READ - SEARCH FOR A MISSING EVENT
        try {
            service.searchEventById(123L);
        } catch (EventNotFoundException e) {
            System.out.println("Search error: " + e.getMessage());
        }

        // 5. DELETE AN EVENT
        boolean firstDeletion = service.deleteEvent(2L);
        boolean secondDeletion = service.deleteEvent(2L);

        System.out.println("First deletion: " + firstDeletion);
        System.out.println("Second deletion: " + secondDeletion);
        System.out.println("Remaining events: " + service.getTotalEvents());

        // 6. CREATE AGAIN AND CHECK DUPLICATE ID
        service.addEvent(new Event(2L, "Tech Meetup SDE", "Bangalore", 150));

        try {
            service.addEvent(new Event(2L, "Duplicate Meetup", "Chennai", 50));
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate error: " + e.getMessage());
        }

        // 7. UPDATE EVENT VENUE
        service.updateEventVenue(2L, "Chennai");

        Event venueUpdated = service.searchEventById(2L);
        System.out.println("Updated venue: " + venueUpdated.getVenue());

        // 8. UPDATE EVENT CAPACITY
        service.addEvent(new Event(3L, "Spring Boot Webinar", "Bangalore", 50));
        service.updateEventCapacity(3L, 100);

        Event capacityUpdated = service.searchEventById(3L);
        System.out.println("Updated capacity: " + capacityUpdated.getMaxCapacity());

        // 9. DISPLAY FINAL EVENT COUNT
        System.out.println("Final total events: " + service.getTotalEvents());
    }
}
