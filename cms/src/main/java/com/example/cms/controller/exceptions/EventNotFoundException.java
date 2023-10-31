package com.example.cms.controller.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(int code) { super("Could not find course " + code); }
}
