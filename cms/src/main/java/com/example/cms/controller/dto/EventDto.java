package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EventDto {
    private Integer eventCode;
    private String eventName;
    private Integer groupId;
    private String roomCode;
    private String date;        // in format "yyyy/MM/dd HH:mm:ss"
    private double duration;
    private String description;
    private String eventType;
    private int eventCapacity;
}
