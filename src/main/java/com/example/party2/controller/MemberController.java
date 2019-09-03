package com.example.party2.controller;

import com.example.party2.model.dto.MemberRequest;
import com.example.party2.model.dto.MemberResponse;
import com.example.party2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/save")
    public MemberResponse saveMember(@RequestBody MemberRequest memberRequest){
        return memberService.saveMember(memberRequest);
    }
}
