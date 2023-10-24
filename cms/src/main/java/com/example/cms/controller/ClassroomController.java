package com.example.cms.controller;

import com.example.cms.controller.exceptions.ClassroomNotFoundException;
import com.example.cms.model.entity.Room;
import com.example.cms.model.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClassroomController
{
    @Autowired
    private final ClassroomRepository repository;

    public ClassroomController(ClassroomRepository repository) {
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





}
