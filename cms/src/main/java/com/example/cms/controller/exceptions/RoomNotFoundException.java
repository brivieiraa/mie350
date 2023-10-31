package com.example.cms.controller.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String BuildingCode) {
        super("Could not find room " + BuildingCode);
    }
}
