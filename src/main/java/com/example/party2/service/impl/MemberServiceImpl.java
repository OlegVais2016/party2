package com.example.party2.service.impl;

import com.example.party2.model.dto.MemberRequest;
import com.example.party2.model.dto.MemberResponse;
import com.example.party2.model.entity.Member;
import com.example.party2.repository.MemberRepository;
import com.example.party2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberResponse saveMember(MemberRequest memberRequest) {
        Member member = Member.builder()
                .email(memberRequest.getEmail())
                .password(memberRequest.getPassword())
                .firstName(memberRequest.getFirstName())
                .lastName(memberRequest.getLastName())
                .build();
        memberRepository.save(member);


        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .build();
    }
}
