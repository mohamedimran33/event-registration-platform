package com.imran.eventplatform.notification;

public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Email notification sent");
    }
}