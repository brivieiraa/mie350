package com.example.cms.controller.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String eventCode) {
        super("Could not find event " + eventCode);
    }
}
