package com.example.party2.exception;

import org.springframework.http.HttpStatus;

public class StatusDoNotMatchException extends BaseException {

    private static final String message = "Status must only 'PENDING'";

    @Override
    public HttpStatus getStatus(){
        return HttpStatus.NOT_ACCEPTABLE;
    }
    public StatusDoNotMatchException(){
        super(message);
    }
}
