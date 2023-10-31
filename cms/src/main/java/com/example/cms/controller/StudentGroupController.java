package com.example.cms.controller;

import com.example.cms.controller.exceptions.StudentGroupNotFoundException;
import com.example.cms.model.entity.StudentGroup;
import com.example.cms.model.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentGroupController {

    @Autowired
    private final StudentGroupRepository repository;

    public StudentGroupController(StudentGroupRepository repository) { this.repository = repository; }

    // RETRIEVE STUDENT GROUPS
    @GetMapping("/studentgroups")
    List<StudentGroup> retrieveAllStudentGroups() { return repository.findAll(); }


    // SEARCH BY ID
    @GetMapping("/studentgroups/{code}")
    StudentGroup retrieveStudentGroup(@PathVariable("code") String groupId) {
        return repository.findById(groupId)
                .orElseThrow(() -> new StudentGroupNotFoundException(groupId));
    }



}
