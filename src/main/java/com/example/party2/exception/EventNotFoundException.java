package com.example.party2.exception;

import org.springframework.http.HttpStatus;

public class EventNotFoundException extends BaseException {

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public EventNotFoundException(Long eventId) {
        super(String.format("Event with ID [%d] not found", eventId));
    }
}
