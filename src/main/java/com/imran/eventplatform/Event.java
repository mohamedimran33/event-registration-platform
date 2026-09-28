package com.imran.eventplatform;

public class Event {
    private Long id;
    private String title;
    private String venue;
    private int maxCapacity;

    public Event(Long id, String title, String venue, int maxCapacity) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.maxCapacity = maxCapacity;
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
}
