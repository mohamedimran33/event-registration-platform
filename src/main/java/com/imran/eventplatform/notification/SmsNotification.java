package com.imran.eventplatform.notification;

public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification(){
        System.out.println("SMS notification Sent");
    }
}
