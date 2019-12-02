package com.example.party2.service;

import com.example.party2.model.dto.member.LoginRequest;
import com.example.party2.model.dto.member.LoginResponse;
import com.example.party2.model.dto.member.MemberRequest;
import com.example.party2.model.dto.member.MemberResponse;
import com.example.party2.model.entity.Member;

import java.util.List;

public interface MemberService {
    MemberResponse saveMember(MemberRequest memberRequest);
    LoginResponse login(LoginRequest loginRequest);
    List<Member> getMembers();
    MemberResponse getByName(String firstName);
    void deleteById(Long id);
}
