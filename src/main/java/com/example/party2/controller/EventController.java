package com.example.party2.controller;

import com.example.party2.model.dto.event.EventRequest;
import com.example.party2.model.dto.event.EventResponse;
import com.example.party2.model.entity.Event;
import com.example.party2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/events/{memberId}")
    public EventResponse createEvent(@PathVariable Long memberId,
                                     @RequestBody EventRequest eventRequest){
        return  eventService.createEvent(memberId, eventRequest);
    }

    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }
    @PostMapping("events/sub/{email}/{eventId}")
    public String subscribeToEvent(@PathVariable String email,
                                   @PathVariable Long eventId) {
        eventService.subscribeToEvent(email,eventId);
        return "Fine";
    }

}

