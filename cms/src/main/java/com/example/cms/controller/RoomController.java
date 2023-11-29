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

    @GetMapping("/classrooms/code/{code}")
    Room retrieveClassroom(@PathVariable("code") String classroomCode) {
        return repository.findById(classroomCode)
                .orElseThrow(() -> new RoomNotFoundException(classroomCode));
    }

    // GET BY BUILDING
    @GetMapping("/classrooms/building/{building}")
    List<Room> retrieveListRoomsWithBuilding(@PathVariable("building") String buildingCode) {
        return repository.searchRoomsInBuilding(buildingCode);
    }

    // GET BY CAPACITY
    @GetMapping("/classrooms/capacity/{capacity}")
    List<Room> retrieveListRoomsWithCapacity(@PathVariable("capacity") int capacityNB) {
        return repository.searchRoomsByCapacity(capacityNB);
    }

//    // GET BY TECHNOLOGY i.e projector, HDMI cable, apple cable
//    @GetMapping("/classrooms/{technology}")
//    Room retrieveByTechnology(@PathVariable("technology") String technologyName) {
//        return repository.findById(technologyName)
//                .orElseThrow(() -> new RoomNotFoundException("Technology desired " + technologyName));
//    }


}
