package com.example.party2.service.impl;

import com.example.party2.exception.EventNotFoundException;
import com.example.party2.model.entity.Event;
import com.example.party2.model.entity.Member;
import com.example.party2.repository.EventRepository;
import com.example.party2.service.CloseSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloseSubscribeServiceImpl implements CloseSubscribeService {

    @Autowired
    private EventRepository eventRepository;

    private JavaMailSender emailSender;

    @Override
    public String closeSubscribe(Member member, Long eventId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));
        if(!event.getArranger().getMemberId().equals(member.getMemberId())){
            return "you are not arranger of event";
        }
        event.setEventStatus(event.getEventStatus().getNextPhase());
        eventRepository.save(event);
        List<Member> participants = event.getParticipants();
        for(Member participant : participants){
            String email = participant.getEmail();
            String subject = "Invite to event " + event.getTitle();
            String text = "You are invited to address: "
                    + event.getCity() + ", " + event.getStreet()
                    + ", My name:  " + event.getArranger().getFirstName()
                    + ", My tel: " + event.getArranger().getNumber()
                    + ", Date: " + event.getDate()
                    + ", Time: " + event.getTime();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        }
        return "closed";
    }
}
