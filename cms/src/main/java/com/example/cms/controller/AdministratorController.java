package com.example.cms.controller;

import com.example.cms.controller.exceptions.AdminNotFoundException;
import com.example.cms.model.entity.Administrator;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
// NEEDS COMPLETING //
public class AdministratorController {

    @Autowired
    private final AdministratorRepository repository;

    public AdministratorController(AdministratorRepository repository) {
        this.repository = repository;
    }

    // RETRIEVE ADMINS
    @GetMapping("/admins") // get all admins
    List<Administrator> retrieveAllAdministrators() {
        return repository.findAll();
    }

    @GetMapping("/admins/{id}") // find admin by id
    Administrator retrieveAdmin(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException(id)); // Need to create AdminNotFoundException
    }

    // CREATE ADMINS
    @PostMapping("/admins")
    Administrator createAdmin(@RequestBody Administrator newAdmin) {
        Long adminId = newAdmin.getId();
        Optional<Administrator> existingAdmin = repository.findById(adminId);
        if (existingAdmin.isPresent()) {
            // If a student with the same ID already exists, handle it (throw an exception, return an error response, etc.)
            throw new RuntimeException("Admin with ID " + adminId + " already exists.");
        } else {
            // If no student with the same ID exists, save the new student
            return repository.save(newAdmin);
        }
    }

    // UPDATE ADMINS
    @PutMapping("/admins/{id}")
    Administrator updateAdmin(@RequestBody Administrator newAdmin, @PathVariable("id") Long adminId) {
        return repository.findById(adminId)
                .map(administrator -> {
                    administrator.setFirstName(newAdmin.getFirstName());
                    administrator.setLastName(newAdmin.getLastName());
                    administrator.setEmail(newAdmin.getEmail());
                    administrator.setUTorId(newAdmin.getUTorId());
                    return repository.save(administrator);
                })
                .orElseGet(() -> {
                    newAdmin.setId(adminId);
                    return repository.save(newAdmin);
                });
    }

    // DELETE ADMINS
    @DeleteMapping("/admins/{id}")
    void deleteAdmin(@PathVariable("id") Long adminId)
    {
        repository.deleteById(adminId);
    }
}
