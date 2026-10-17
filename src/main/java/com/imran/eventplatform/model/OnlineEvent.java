package com.imran.eventplatform.model;

public class OnlineEvent extends Event {

    private String meetingLink;

    public OnlineEvent(Long id, String title, String venue, int maxCapacity, String meetingLink) {
        super(id, title, venue, maxCapacity);
        this.meetingLink = meetingLink;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    @Override
    public void printSummary() {
        super.printSummary();
        System.out.println("Meeting Link:" + meetingLink);
    }
}
