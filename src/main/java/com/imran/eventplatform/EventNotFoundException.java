package com.imran.eventplatform;

public class EventNotFoundException extends RuntimeException{

    EventNotFoundException(String message){
        throw new EventNotFoundException("Event not found");
        super(message);
    }
}
