package com.example.cms.controller;

import com.example.cms.controller.exceptions.RoomNotFoundException;
import com.example.cms.model.entity.Room;
import com.example.cms.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// NEEDS COMPLETING //
@CrossOrigin
@RestController
public class RoomController
{
    @Autowired
    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/classrooms")
    List<Room> retreiveAllClassrooms() {
        return repository.findAll();
    }

    @GetMapping("/classrooms/{code}")
    Room retrieveClassroom(@PathVariable("code") String classroomCode) {
        return repository.findById(classroomCode)
                .orElseThrow(() -> new RoomNotFoundException(classroomCode));
    }

    // GET BY BUILDING

    // GET BY CAPACITY

    // GET BY TECHNOLOGY?



}
