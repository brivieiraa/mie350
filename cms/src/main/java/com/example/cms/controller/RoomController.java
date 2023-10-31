package com.example.cms.controller;

import com.example.cms.controller.exceptions.ClassroomNotFoundException;
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
                .orElseThrow(() -> new ClassroomNotFoundException(classroomCode));
    }

    // GET BY BUILDING
    @GetMapping("/classrooms/{building}")
    Room retrieveByBuilding(@PathVariable("building") String buildingCode) {
        return repository.findById(buildingCode)
                .orElseThrow(() -> new ClassroomNotFoundException("Building code " +  buildingCode));
    }

    // GET BY CAPACITY
    @GetMapping("/classrooms/{capacity}")
    Room retrieveByCapacity(@PathVariable("capacity") String capacityNB) {
        return repository.findById(capacityNB)
                .orElseThrow(() -> new ClassroomNotFoundException("Capacity number " + capacityNB));
    }

    // GET BY TECHNOLOGY i.e projector, HDMI cable, apple cable
    @GetMapping("/classrooms/{technology}")
    Room retrieveByTechnology(@PathVariable("technology") String technologyName) {
        return repository.findById(technologyName)
                .orElseThrow(() -> new ClassroomNotFoundException("Technology desired " + technologyName));
    }


}
