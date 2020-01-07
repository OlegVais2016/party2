package com.example.party2.controller;

import com.example.party2.model.dto.event.EventRequest;
import com.example.party2.model.dto.event.EventResponse;
import com.example.party2.model.entity.Event;
import com.example.party2.model.entity.Member;
import com.example.party2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/events/me")
    public EventResponse createEvent(@AuthenticationPrincipal Member member,
                                     @RequestBody EventRequest eventRequest){
        return  eventService.createEvent(member, eventRequest);
    }

    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @PostMapping("events/sub/me/{eventId}")
    public String subscribeToEvent(@AuthenticationPrincipal Member member,
                                   @PathVariable Long eventId) {
        eventService.subscribeToEvent(member,eventId);
        return "You are subscribed!";
    }

}

