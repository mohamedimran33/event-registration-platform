package com.imran.eventplatform.service;

import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;

import java.util.ArrayList;

public class EventService {

   private ArrayList<Event> events=new ArrayList<>();

   public void addEvent(Event event){
       events.add(event);
   }

   public int getTotalEvents(){
       return events.size();
   }

   public Event searchEventById(Long id){
       for ( Event e:events){
           if(e.getId().equals(id)){
               return e;
           }
       }

       throw new EventNotFoundException("Event with id " + id + " Not found");
   }
}
