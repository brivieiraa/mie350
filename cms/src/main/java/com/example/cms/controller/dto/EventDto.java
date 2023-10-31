package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EventDto {
    private int eventCode;
    private String eventName;
    private String groupId;
    private String roomCode;
    private String date;
    private String time;
    private String description;
    private String eventType;
    private int eventCapacity;
}
