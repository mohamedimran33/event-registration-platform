package com.imran.eventplatform;

public class Event {
    private Long id;
    private String title;
    private String venue;
    private int maxCapacity;

    public Event(Long id, String title, String venue, int maxCapacity) {

        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Event Title Cannot be Empty");
        }

        if(venue==null || venue.isBlank()){
            throw new IllegalArgumentException("Event venue Cannot be Empty");
        }

        if(maxCapacity<0){
            throw new IllegalArgumentException("Enter a Valid Capacity ");
        }

        this.id = id;
        this.title = title;
        this.venue = venue;
        this.maxCapacity = maxCapacity;

        eventCount++;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVenue() {
        return venue;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void updateCapacity(int newCapacity){
        if(newCapacity<=0){
            throw new IllegalArgumentException("Capacity should be greater than zero");
        }

        this.maxCapacity=newCapacity;
    }

    public void updateVenue(String newVenue){
        if(newVenue==null || newVenue.isBlank()){
            throw new IllegalArgumentException("please update with the valid venue");
        }

        this.venue=newVenue;
    }

    public void printSummary(){
        System.out.println("Event :"+ title);
        System.out.println("Venue :"+ venue);
        System.out.println("capacity:"+ maxCapacity);
    }

    private static int eventCount=0;

    public static int getEventCount() {
        return eventCount;
    }
}
