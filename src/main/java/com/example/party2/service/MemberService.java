package com.example.party2.service;

import com.example.party2.model.dto.MemberRequest;
import com.example.party2.model.dto.MemberResponse;

public interface MemberService {
    MemberResponse saveMember(MemberRequest memberRequest);
}
