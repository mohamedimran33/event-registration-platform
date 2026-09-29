package com.imran.eventplatform;

public class Main {
    public static void main(String[] args) {
        Event javaWorkshop=new Event(1l,"java wokshop","chennai",50);
        Event aiConference=new Event(2l,"ai Conference","Bangalore",200);
        Event springBootEvent=new Event(3l,"Spring Boot Event","Bangalore",350);

        System.out.println(javaWorkshop.getTitle());
        System.out.println(javaWorkshop.getVenue());
        System.out.println(javaWorkshop.getMaxCapacity());

        System.out.println();

        System.out.println(aiConference.getTitle());
        System.out.println(aiConference.getVenue());
        System.out.println(aiConference.getMaxCapacity());

        System.out.println();

        System.out.println(springBootEvent.getTitle());
        System.out.println(springBootEvent.getVenue());
        System.out.println(springBootEvent.getMaxCapacity());

        springBootEvent.updateCapacity(400);

        System.out.println(springBootEvent.getMaxCapacity());

        springBootEvent.updateVenue("Coimbatore");

        System.out.println(springBootEvent.getVenue());



    }
}