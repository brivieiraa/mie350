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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// NEEDS COMPLETING //

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    private final EventRepository repository;

    public EventController(EventRepository repository) { this.repository = repository; }

    // GET ALL EVENTS

    // SEARCH BY MONTH

    // SEARCH BY DATE

    // SEARCH BY CLUB

    // SEARCH BY NAME

    // SEARCH BY BUILDING

    // SEARCH BY ROOM

    // CREATE EVENT
        // ADMIN ONLY

    // UPDATE EVENT
        // ADMIN ONLY

    // DELETE EVENT
        // ADMIN ONLY
}
