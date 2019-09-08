package com.example.party2.service.impl;

import com.example.party2.model.dto.event.EventRequest;
import com.example.party2.model.dto.event.EventResponse;
import com.example.party2.model.entity.Event;
import com.example.party2.model.entity.Member;
import com.example.party2.repository.EventRepository;
import com.example.party2.repository.MemberRepository;
import com.example.party2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public EventResponse createEvent(Long memberId, EventRequest eventRequest) {

        Optional<Member> member = memberRepository.findById(memberId);
        Event event = Event.builder()
                .arranger(member.get())
                .title(eventRequest.getTitle())
                .city(eventRequest.getCity())
                .street(eventRequest.getStreet())
                .house(eventRequest.getHouse())
                .build();

        eventRepository.save(event);

        return EventResponse.builder()
                .firstName(event.getArranger().getFirstName())
                .title(event.getTitle())
                .city(event.getCity())
                .street(event.getStreet())
                .house(event.getHouse())
                .build();
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}

