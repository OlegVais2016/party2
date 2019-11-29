package com.example.party2.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException{

    public HttpStatus getStatus(){
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
