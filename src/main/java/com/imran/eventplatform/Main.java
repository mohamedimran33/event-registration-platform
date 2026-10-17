package com.imran.eventplatform;

import com.imran.eventplatform.Notification.EmailNotification;
import com.imran.eventplatform.Notification.NotificationService;
import com.imran.eventplatform.Notification.SmsNotification;
import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;
import com.imran.eventplatform.model.OnlineEvent;

public class Main {
    public static void main(String[] args) {
        Event javaWorkshop = new Event(1l, "java wokshop", "chennai", 50);
//        Event aiConference=new Event(2l,"ai Conference","Bangalore",200);
        Event springBootEvent = new Event(3l, "Spring Boot Event", "Bangalore", 350);

        System.out.println(javaWorkshop.getTitle());
        System.out.println(javaWorkshop.getVenue());
        System.out.println(javaWorkshop.getMaxCapacity());

        System.out.println();

//        System.out.println(aiConference.getTitle());
//        System.out.println(aiConference.getVenue());
//        System.out.println(aiConference.getMaxCapacity());

        System.out.println();

        System.out.println(springBootEvent.getTitle());
        System.out.println(springBootEvent.getVenue());
        System.out.println(springBootEvent.getMaxCapacity());

        springBootEvent.updateCapacity(400);

        System.out.println(springBootEvent.getMaxCapacity());

        springBootEvent.updateVenue("Coimbatore");

        System.out.println(springBootEvent.getVenue());

        System.out.println();

        javaWorkshop.printSummary();

        springBootEvent.printSummary();

        System.out.println();

        System.out.println(Event.getEventCount());


        try {
            Event invalidEvent = new Event(4l, "", "chennai", 0);
            System.out.println(invalidEvent.getMaxCapacity());

        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e.getMessage());
        }

        try {
            Event pythonWorkshop = new Event(5l, "python workshop", "coimbatore", -1);
            System.out.println(pythonWorkshop.getMaxCapacity());
        } catch (IllegalArgumentException e) {
            System.out.println("Error" + e.getMessage());
        }

        try {
            Event WebDevClass = new Event(6l, "Web Development Seminar", "Erode", 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            System.out.println("Event creation attempt completed");
        }

        try {
            testEvent(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e.getMessage());
        }

        try {
            testEvent(100);
            System.out.println("100 is valid");
        } catch (IllegalArgumentException e) {
            System.out.println("error:" + e.getMessage());
        }

        System.out.println();

        try {
            findEvent(999);
        } catch (EventNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
        }

        System.out.println();

        try {
            findEvent(1);
        } catch (EventNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
        }

        OnlineEvent webinar=new OnlineEvent(10L,"Java Backend Webinar","Online",90,"https://meet.example.com");
        System.out.println();
        System.out.println(webinar.getTitle());
        System.out.println(webinar.getMeetingLink());

        System.out.println();
        webinar.printSummary();

        System.out.println();
        Event event=new OnlineEvent(20L,"Spring Webinar","online",100,"https://meet.example.com/spring");
        event.printSummary();


        //for polymorphism check(Dynamic method Dispatch)
        System.out.println();
        javaWorkshop.printSummary();
        System.out.println();
        webinar.printSummary();

        System.out.println();
        NotificationService email=new EmailNotification();
        NotificationService sms=new SmsNotification();
        email.sendNotification();
        sms.sendNotification();
    }


    public static void testEvent(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("the capacity you entered is incorrect");
        }
    }

    public static void findEvent(int id) {
        if (id != 1 && id != 3) {
            throw new EventNotFoundException("Event with id " + id + " not found");

        }
        System.out.println("Event Found");

    }


}