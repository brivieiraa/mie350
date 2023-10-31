package com.example.cms.controller.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String eventCode) {
        super("Could not find course " + eventCode);
    }
}
