package com.example.party2.service;

import com.example.party2.model.entity.Member;

public interface CloseSubscribeService {

    String closeSubscribe(Member member,Long eventId);
}
