package com.example.party2.service;

import com.example.party2.model.dto.member.MemberRequest;
import com.example.party2.model.entity.Member;
import com.example.party2.repository.MemberRepository;
import com.example.party2.service.impl.MemberServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceImplTest {

    private static final String INCORRECT_EMAIL = "incorrect_email";
    private static final String INCORRECT_PASSWORD = "incorrect_password";
    private static final Member DEFAULT_MEMBER =
            Member.builder()
                    .memberId(1L)
                    .email("1_person@gmail.com")
                    .password("123456")
                    .firstName("Bob")
                    .lastName("Dilan")
                    .build();
    @InjectMocks
    private MemberServiceImpl memberService;
    @Mock
    private MemberRepository memberRepository;

    //------------------------------------saveMemberTest------------------

    @Test
    public void save_positive(){
        Mockito.when(memberRepository.save(ArgumentMatchers.any(Member.class)))
                .thenReturn(DEFAULT_MEMBER);
        MemberRequest request = MemberRequest.builder()
                .email(DEFAULT_MEMBER.getEmail())
                .password(DEFAULT_MEMBER.getPassword())
                .firstName(DEFAULT_MEMBER.getFirstName())
                .lastName(DEFAULT_MEMBER.getLastName())
                .build();
        memberService.saveMember(request);
    }

}
