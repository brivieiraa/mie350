package com.example.cms.controller;

import com.example.cms.controller.dto.EventDto;

import com.example.cms.model.entity.Event;
import com.example.cms.model.repository.EventRepository;
import com.example.cms.controller.exceptions.EventNotFoundException;

import com.example.cms.model.entity.StudentGroup;
import com.example.cms.model.repository.StudentGroupRepository;
import com.example.cms.controller.exceptions.StudentGroupNotFoundException;

import com.example.cms.model.entity.Room;
import com.example.cms.model.repository.RoomRepository;
import com.example.cms.controller.exceptions.RoomNotFoundException;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// NEEDS COMPLETING //

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    private final EventRepository repository;

    public EventController(EventRepository repository) { this.repository = repository; }

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private RoomRepository roomRepository;

    // GET ALL EVENTS
    @GetMapping("/events")
    List<Event> retrieveAllEvents() { return repository.findAll(); }

    // SEARCH BY MONTH

    // SEARCH BY DATE

    // SEARCH BY CLUB

    // SEARCH BY NAME

    // SEARCH BY BUILDING

    // SEARCH BY ROOM

    // CREATE EVENT
        // ADMIN ONLY
    @PostMapping("/events")
    Event createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = new Event();
        newEvent.setEventCode(eventDto.getEventCode());
        newEvent.setEventName(eventDto.getEventName());
        newEvent.setEventType(eventDto.getEventType());
        newEvent.setDescription(eventDto.getDescription());

        StudentGroup group = studentGroupRepository.findById(eventDto.getGroupId()).orElseThrow(
                () -> new StudentGroupNotFoundException(eventDto.getGroupId()));
        newEvent.setStudentGroup(group);

        Room room = roomRepository.findById(eventDto.getRoomCode()).orElseThrow(
                () -> new RoomNotFoundException(eventDto.getRoomCode()));
        newEvent.setRoom(room);


    }


    // UPDATE EVENT
        // ADMIN ONLY

    // DELETE EVENT
        // ADMIN ONLY
}
