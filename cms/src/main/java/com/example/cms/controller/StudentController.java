package com.example.cms.controller;

import com.example.cms.controller.exceptions.StudentNotFoundException;
import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.RSVPRepository;
import com.example.cms.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// NEEDS COMPLETING //
@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private final StudentRepository repository;

    @Autowired
    private RSVPRepository rsvpRepository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<Student> retrieveAllStudents() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student createStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @GetMapping("/students/{id}")
    Student retrieveStudent(@PathVariable("id") Long studentId) {
        return repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable("id") Long studentId) {
        return repository.findById(studentId)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setEmail(newStudent.getEmail());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(studentId);
                    return repository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") Long studentId)
    {
        List<Integer> eventRSVP = repository.findRsvpStudent(studentId);

        if (!eventRSVP.isEmpty())
        {
            for (Integer eventCode : eventRSVP)
            {
                RSVPKey key = new RSVPKey(studentId, eventCode);
                rsvpRepository.deleteById(key);
            }
        }

        repository.deleteById(studentId);
    }

    @GetMapping("/students/search/{searchstring}")
    List<Student> searchStudent(@PathVariable("searchstring") String searchString) {
        return repository.search(searchString);
    }

}
