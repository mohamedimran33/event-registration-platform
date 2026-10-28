
package com.imran.eventplatform.practice;

import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;
import com.imran.eventplatform.model.OnlineEvent;
import com.imran.eventplatform.notification.EmailNotification;
import com.imran.eventplatform.notification.NotificationService;
import com.imran.eventplatform.notification.SmsNotification;

import java.util.ArrayList;
import java.util.HashMap;

public class Practice {

    public static void main(String[] args) {

        // 1. Create sample events
        Event javaWorkshop = new Event(
                1L, "Java Workshop", "Chennai", 50
        );

        Event springBootEvent = new Event(
                3L, "Spring Boot Event", "Bangalore", 350
        );

        // 2. Encapsulation, getters and updates
        practiceEncapsulation(javaWorkshop, springBootEvent);

        // 3. Constructors, validation and exceptions
        practiceExceptions();

        // 4. Inheritance, overriding and polymorphism
        practiceInheritance(javaWorkshop);

        // 5. Interfaces and notification polymorphism
        practiceNotifications();

        // 6. ArrayList and event searching
        ArrayList<Event> events = new ArrayList<>();
        events.add(javaWorkshop);
        events.add(springBootEvent);

        practiceArrayList(events);

        // 7. HashMap and key-based searching
        practiceHashMap(events);
    }

    // 1. ENCAPSULATION AND OBJECT METHODS
    public static void practiceEncapsulation(
            Event javaWorkshop, Event springBootEvent) {

        System.out.println("\n--- ENCAPSULATION ---");

        System.out.println(javaWorkshop.getTitle());
        System.out.println(javaWorkshop.getVenue());
        System.out.println(javaWorkshop.getMaxCapacity());

        springBootEvent.updateCapacity(400);
        springBootEvent.updateVenue("Coimbatore");

        javaWorkshop.printSummary();
        springBootEvent.printSummary();

        System.out.println("Created events: " + Event.getEventCount());
    }

    // 2. EXCEPTION HANDLING AND VALIDATION
    public static void practiceExceptions() {

        System.out.println("\n--- EXCEPTIONS ---");

        try {
            new Event(4L, "", "Chennai", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            new Event(5L, "Python Workshop", "Coimbatore", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            new Event(6L, "Web Development Seminar", "Erode", 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Event creation attempt completed");
        }

        try {
            testEvent(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        testEvent(100);
        System.out.println("100 is valid");

        try {
            findEvent(999);
        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        findEvent(1);
    }

    // 3. INHERITANCE AND METHOD OVERRIDING
    public static void practiceInheritance(Event javaWorkshop) {

        System.out.println("\n--- INHERITANCE ---");

        OnlineEvent webinar = new OnlineEvent(
                10L,
                "Java Backend Webinar",
                "Online",
                90,
                "https://meet.example.com"
        );

        System.out.println(webinar.getMeetingLink());
        webinar.printSummary();

        // Parent reference holding a child object
        Event onlineEvent = new OnlineEvent(
                20L,
                "Spring Webinar",
                "Online",
                100,
                "https://meet.example.com/spring"
        );

        // Runtime polymorphism
        javaWorkshop.printSummary();
        onlineEvent.printSummary();
    }

    // 4. INTERFACES AND POLYMORPHISM
    public static void practiceNotifications() {

        System.out.println("\n--- NOTIFICATIONS ---");

        NotificationService email = new EmailNotification();
        NotificationService sms = new SmsNotification();

        email.sendNotification();
        sms.sendNotification();

        notifyUser(new EmailNotification());
        notifyUser(new SmsNotification());
    }

    // 5. ARRAYLIST AND LINEAR SEARCH
    public static void practiceArrayList(ArrayList<Event> events) {

        System.out.println("\n--- ARRAYLIST ---");

        System.out.println("Total stored events: " + events.size());
        System.out.println("Second event: " + events.get(1).getTitle());

        for (Event event : events) {
            System.out.println(event.getTitle());
        }

        Event found = findEventById(events, 3L);
        System.out.println("Found: " + found.getTitle());

        try {
            findEventById(events, 4L);
        } catch (EventNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 6. HASHMAP AND KEY-BASED SEARCH
    public static void practiceHashMap(ArrayList<Event> events) {

        System.out.println("\n--- HASHMAP ---");

        HashMap<Long, Event> eventMap = new HashMap<>();

        for (Event event : events) {
            eventMap.put(event.getId(), event);
        }

        Event foundEvent = eventMap.get(3L);
        System.out.println("Found: " + foundEvent.getTitle());

        System.out.println("ID 99 exists: " + eventMap.containsKey(99L));

        Event searchedEvent = eventMap.get(999L);

        if (searchedEvent == null) {
            System.out.println("Event not found");
        } else {
            System.out.println(searchedEvent.getTitle());
        }
    }

    // HELPER: VALIDATE CAPACITY
    public static void testEvent(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero"
            );
        }
    }

    // HELPER: OLD HARDCODED SEARCH EXERCISE
    public static void findEvent(int id) {
        if (id != 1 && id != 3) {
            throw new EventNotFoundException(
                    "Event with ID " + id + " not found"
            );
        }

        System.out.println("Event found");
    }

    // HELPER: INTERFACE POLYMORPHISM
    public static void notifyUser(NotificationService notification) {
        notification.sendNotification();
    }

    // HELPER: ARRAYLIST EVENT SEARCH
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
