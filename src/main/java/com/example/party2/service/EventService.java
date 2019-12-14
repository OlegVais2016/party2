package com.example.party2.service;

import com.example.party2.model.dto.event.EventRequest;
import com.example.party2.model.dto.event.EventResponse;
import com.example.party2.model.entity.Event;
import com.example.party2.model.entity.Member;

import java.util.List;

public interface EventService {

    EventResponse createEvent(Long memberId, EventRequest eventRequest);
    List<Event> getEvents();
    void subscribeToEvent(Member member, Long eventId);
}
