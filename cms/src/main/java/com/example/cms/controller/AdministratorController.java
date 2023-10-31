package com.example.cms.controller;

import com.example.cms.controller.exceptions.AdminNotFoundException;
import com.example.cms.model.entity.Administrator;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// NEEDS COMPLETING //
public class AdministratorController {

    @Autowired
    private final AdministratorRepository repository;

    public AdministratorController(AdministratorRepository repository) {
        this.repository = repository;
    }
    // CREATE ADMIN

    // RETRIEVE ADMINS
    @GetMapping("/admins") // get all admins
    List<Administrator> retrieveAllAdministrators() {
        return repository.findAll();
    }

    @GetMapping("/admins/{id}") // find admin by id
    Student retrieveStudent(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id)); // Need to create AdminNotFoundException
    }

    // UPDATE ADMINS

    // DELETE ADMINS

}
