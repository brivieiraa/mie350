package com.example.cms.controller;
import com.example.cms.controller.dto.RSVPDto;
import com.example.cms.controller.exceptions.CourseNotFoundException;
import com.example.cms.controller.exceptions.StudentNotFoundException;
import com.example.cms.model.entity.Event;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.EventRepository;
import com.example.cms.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import com.example.cms.model.repository.RSVPRepository;

public class RSVPController {
    @Autowired
    private RSVPRepository repository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EventRepository eventRepository;

    

    // ADD RSVP
    @PostMapping("/RSVP")
    RSVP createRSVP(@RequestBody RSVPDto rsvpDto) {
        RSVP newRSVP = new RSVP();
        long studentId = rsvpDto.getStudentId();
        String eventCode = rsvpDto.getEventCode();

        RSVPKey key = new RSVPKey();
        key.setStudentId(rsvpDto.getStudentId());
        key.setEventCode(rsvpDto.getEventCode());

        Event event = eventRepository.findById(eventCode).orElseThrow(
                () -> new CourseNotFoundException(eventCode));
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException(studentId));

        newRSVP.setStudent(student);
        newRSVP.setEvent(event);

        return repository.save(newRSVP);
    }

    // REMOVE RSVP
    @DeleteMapping("/RSVP/{eventCode}/{studentID}")
    void deleteRSVP(@PathVariable("eventCode") String eventCode,
                    @PathVariable("studentID") long studentID){
        RSVPKey key = new RSVPKey();
        key.setEventCode(eventCode);
        key.setStudentId(studentID);
        repository.deleteById(key);
    }
}
