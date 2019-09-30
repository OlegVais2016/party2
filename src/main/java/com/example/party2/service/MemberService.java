package com.example.party2.service;

import com.example.party2.model.dto.member.MemberRequest;
import com.example.party2.model.dto.member.MemberResponse;
import com.example.party2.model.entity.Member;

import java.util.List;

public interface MemberService {
    MemberResponse saveMember(MemberRequest memberRequest);
    List<Member> getMembers();
    MemberResponse getByName(String firstName);
    void deleteById(Long id);
}
