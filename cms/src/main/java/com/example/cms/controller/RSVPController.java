package com.example.cms.controller;

import com.example.cms.controller.dto.RSVPDto;
import com.example.cms.controller.exceptions.EventNotFoundException;
import com.example.cms.controller.exceptions.StudentGroupNotFoundException;
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
import java.util.List;

@CrossOrigin
@RestController
public class RSVPController {
    @Autowired
    private final RSVPRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    public RSVPController(RSVPRepository repository) { this.repository = repository; }

    // SEE RSVPS
    @GetMapping("/rsvp")
    List<RSVP> retrieveAllRsvps() { return repository.findAll(); }

//    @GetMapping("/rsvps/{eventCode}")
//    RSVP retrieveRSVP(@PathVariable("eventCode") Long eventCode) {
//        return repository.findBy(eventCode)
//                .orElseThrow(() -> new StudentNotFoundException(eventCode));
//    }

    // SEE RSVPs given studentID
    @GetMapping("/rsvp/{studentId}")
    List<Integer> retrieveAllRsvpsByStudent(@PathVariable("studentId") Long studentId) {
        return repository.findRSVPbyStudent(studentId);
    }

//    @GetMapping("/rsvps/{eventCode}")
//    RSVP retrieveRSVP(@PathVariable("eventCode") Long eventCode) {
//        return repository.findBy(eventCode)
//                .orElseThrow(() -> new StudentNotFoundException(eventCode));
//    }

    // ADD RSVP
    @PostMapping("/rsvp")
    RSVP createRSVP(@RequestBody RSVPDto rsvpDto) {
        RSVP newRSVP = new RSVP();
        Long studentId = rsvpDto.getStudentId();
        Integer eventCode = rsvpDto.getEventCode();

        RSVPKey rsvpkey = new RSVPKey();
        rsvpkey.setStudentId(rsvpDto.getStudentId());
        rsvpkey.setEventCode(rsvpDto.getEventCode());

        Event event = eventRepository.findById(eventCode).orElseThrow(
                () -> new EventNotFoundException(eventCode));
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException(studentId));

        newRSVP.setStudent(student);
        newRSVP.setEvent(event);
        newRSVP.setRsvpKey(rsvpkey);

        return repository.save(newRSVP);
    }

    // REMOVE RSVP
    @DeleteMapping("/rsvp/{eventCode}/{studentID}")
    void deleteRSVP(@PathVariable("eventCode") int eventCode,
                    @PathVariable("studentID") long studentID){
        RSVPKey key = new RSVPKey();
        key.setEventCode(eventCode);
        key.setStudentId(studentID);
        repository.deleteById(key);
    }
}

