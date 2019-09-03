package com.example.party2.controller;

import com.example.party2.model.dto.MemberRequest;
import com.example.party2.model.dto.MemberResponse;
import com.example.party2.model.entity.Member;
import com.example.party2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/save")
    public MemberResponse saveMember(@RequestBody MemberRequest memberRequest){
        return memberService.saveMember(memberRequest);
    }

    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }
}
