package com.example.party2.service.impl;

import com.example.party2.model.dto.event.EventRequest;
import com.example.party2.model.dto.event.EventResponse;
import com.example.party2.model.entity.Event;
import com.example.party2.model.entity.Member;
import com.example.party2.repository.EventRepository;
import com.example.party2.repository.MemberRepository;
import com.example.party2.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
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

    @Override
    public void subscribeToEvent(Long memberId, Long eventId) throws Exception {

        Member member = Member.builder().memberId(memberId).build();
        Event event = eventRepository.findById(eventId).orElseThrow(()->new Exception());

        List<Member> members = event.getParticipants();
       if(members == null){
            List<Member> m = new ArrayList<>();
            m.add(member);
            Event res1 = Event.builder()
                    .eventId(eventId)
                    .participants(m)
                    .build();
            eventRepository.save(res1);
        }
        if(members != null)
        members.add(member);
        Event res = Event.builder()
                .eventId(eventId)
                .participants(members)
                .build();
        eventRepository.save(res);

    }
}

