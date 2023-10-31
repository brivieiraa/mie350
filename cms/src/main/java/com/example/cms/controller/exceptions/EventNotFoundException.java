package com.example.cms.controller.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String code) { super("Could not find course " + code); }
}
