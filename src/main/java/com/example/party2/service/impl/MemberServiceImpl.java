package com.example.party2.service.impl;

import com.example.party2.exception.AuthenticationException;
import com.example.party2.model.dto.member.LoginRequest;
import com.example.party2.model.dto.member.LoginResponse;
import com.example.party2.model.dto.member.MemberRequest;
import com.example.party2.model.dto.member.MemberResponse;
import com.example.party2.model.entity.Member;
import com.example.party2.model.entity.MemberSession;
import com.example.party2.repository.MemberRepository;
import com.example.party2.repository.MemberSessionRepository;
import com.example.party2.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberSessionRepository memberSessionRepository;

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

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findByEmailAndPassword
                (loginRequest.getEmail(), loginRequest.getPassword());
        if (member == null) {
            log.warn("Incorrect username or password. Incoming parameters are: {} - {}",
                    loginRequest.getEmail(), loginRequest.getPassword());
            throw new AuthenticationException("Username or password is incorrect");
        }
        MemberSession memberSession =
                memberSessionRepository.save(MemberSession.builder()
                        .sessionId(UUID.randomUUID().toString())
                        .member(member)
                        .isValid(true)
                .build());
        log.debug("User with name = {} logged in", member.getFirstName());
        return LoginResponse.builder()
                .token(memberSession.getSessionId())
                .build();
    }

    @Override
    public void logout(String header) {

        MemberSession memberSession = memberSessionRepository
                .findBySessionIdAndAndIsValidTrue(header);
        if(memberSession == null){
            log.warn("Logout call - no session ID found = {}, after passing security filter. Exiting without an error", header);
            throw new AuthenticationException("Username or password is incorrect");
        }
        memberSession.setIsValid(false);
        memberSessionRepository.save(memberSession);
        log.debug("Session ID = {} invalidated", header);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public MemberResponse getByName(String firstName) {
        Member member =  memberRepository.findByName(firstName);
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

}
