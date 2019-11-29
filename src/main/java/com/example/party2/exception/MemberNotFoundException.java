package com.example.party2.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends BaseException {

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public MemberNotFoundException(Long memberId) {
        super(String.format("Member with ID [%d] not found", memberId));
    }
}
