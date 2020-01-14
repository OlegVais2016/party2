package com.example.party2.service.impl;

import com.example.party2.exception.EventNotFoundException;
import com.example.party2.model.entity.Event;
import com.example.party2.model.entity.Member;
import com.example.party2.repository.EventRepository;
import com.example.party2.service.CloseSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloseSubscribeServiceImpl implements CloseSubscribeService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public String closeSubscribe(Member member, Long eventId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        event.setEventStatus(event.getEventStatus().getNextPhase());

        return null;
    }
}
