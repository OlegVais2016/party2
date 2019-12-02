package com.example.party2.controller;

import com.example.party2.model.dto.member.LoginRequest;
import com.example.party2.model.dto.member.LoginResponse;
import com.example.party2.model.dto.member.MemberRequest;
import com.example.party2.model.dto.member.MemberResponse;
import com.example.party2.model.entity.Member;
import com.example.party2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/members")
    public MemberResponse saveMember(@RequestBody MemberRequest memberRequest){
        return memberService.saveMember(memberRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return memberService.login(loginRequest);
    }

    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @GetMapping("/memberbyname")
    public MemberResponse getByName(@RequestParam String firstName){
        return memberService.getByName(firstName);
    }

    @PostMapping("/members/{id}")
    public void delete(@PathVariable Long id){
        memberService.deleteById(id);
    }


}
