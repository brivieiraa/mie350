package com.example.cms.controller.exceptions;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String code) {
        super("Could not find room " + code);
    }
}
