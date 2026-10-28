package com.imran.eventplatform.service;

import com.imran.eventplatform.exception.EventNotFoundException;
import com.imran.eventplatform.model.Event;

import java.util.ArrayList;

public class EventService {

   private ArrayList<Event> events=new ArrayList<>();

   public void addEvent(Event event){
       for(Event e:events){
           if(e.getId().equals(event.getId())) {
               throw new IllegalArgumentException(" Id already present");
           }
       }
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

   public boolean deleteEvent(Long id){
       events.removeIf(event -> event.getId().equals(id));
       return true;
   }

   public void updateEventVenue(Long id, String newVenue){
       Event venue=searchEventById(id);
       venue.updateVenue(newVenue);
   }

   public void updateEventCapacity(Long id, int newCapacity){
       Event capacity=searchEventById(id);
       capacity.updateCapacity(newCapacity);
   }
}
