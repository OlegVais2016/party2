package com.example.party2.controller;

import com.example.party2.model.entity.Member;
import com.example.party2.service.CloseSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CloseSubscribeController {

    @Autowired
    private CloseSubscribeService closeSubscribeService;

    @PostMapping("/events/me/{eventId}")
    public String closeSubscribe(@AuthenticationPrincipal Member member,
                                 @PathVariable Long eventId){
        return closeSubscribeService.closeSubscribe(member,eventId);
    }
}
