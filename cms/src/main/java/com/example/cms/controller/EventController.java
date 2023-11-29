package com.example.cms.controller;

import com.example.cms.controller.dto.EventDto;

import com.example.cms.controller.dto.RSVPDto;
import com.example.cms.model.entity.*;
import com.example.cms.model.repository.EventRepository;
import com.example.cms.controller.exceptions.EventNotFoundException;

import com.example.cms.model.repository.StudentGroupRepository;
import com.example.cms.controller.exceptions.StudentGroupNotFoundException;

import com.example.cms.model.repository.RoomRepository;
import com.example.cms.controller.exceptions.RoomNotFoundException;

import com.example.cms.model.repository.StudentRepository;
import com.example.cms.model.repository.RSVPRepository;
import com.example.cms.controller.RSVPController;

import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// NEEDS COMPLETING //

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    private final EventRepository repository;

    public EventController(EventRepository repository) { this.repository = repository; }

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RSVPRepository rsvpRepository;

    // GET ALL EVENTS
    @GetMapping("/events")
    List<Event> retrieveAllEvents() { return repository.findAll(); }

    // GET BY CODE
    @GetMapping("/events/{code}")
    Event retriveEvent(@PathVariable("code") int eventCode) {
        return repository.findById(eventCode)
                .orElseThrow(() -> new EventNotFoundException(eventCode));
    }

    // SEARCH BY MONTH
    // SEARCH BY DATE
    // SEARCH BY CLUB
    // SEARCH BY NAME
    // SEARCH BY BUILDING
    // SEARCH BY ROOM
    // ALREADY IMPLEMENTED AS FEATURE IN FRONT END

    // CREATE EVENT
        // ADMIN ONLY
    @PostMapping("/events")
    Event createEvent(@RequestBody EventDto eventDto) throws ParseException {
        Event newEvent = new Event();
        newEvent.setEventCode(eventDto.getEventCode());
        newEvent.setEventName(eventDto.getEventName());
        newEvent.setEventType(eventDto.getEventType());
        newEvent.setDescription(eventDto.getDescription());
        newEvent.setDuration(eventDto.getDuration());

        StudentGroup group = studentGroupRepository.findById(eventDto.getGroupId()).orElseThrow(
                () -> new StudentGroupNotFoundException(eventDto.getGroupId()));
        newEvent.setStudentGroup(group);

        Room room = roomRepository.findById(eventDto.getRoomCode()).orElseThrow(
                () -> new RoomNotFoundException(eventDto.getRoomCode()));
        newEvent.setRoom(room);

        String date = eventDto.getDate();
        newEvent.setDate(date);

        // IDK IF WE WANT TO TRY TO FIGURE OUT HOW TO USE DATE OBJECTS INSTEAD OF JUST STRINGS
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = sdf.parse(eventDto.getDate());
        //newEvent.setDate(date);

        // make sure capacity is at or below room capacity
        int capacity = eventDto.getEventCapacity();
        if ((capacity > room.getCapacity()) /*|| (capacity == null)*/) {
            capacity = room.getCapacity();
            newEvent.setEventCapacity(capacity);
        }
        else {
            newEvent.setEventCapacity(capacity);
        }
        return repository.save(newEvent);
    }

    // UPDATE EVENT
        // ADMIN ONLY
    @PutMapping("/events/{code}")
    Event updateEvent(@RequestBody EventDto eventDto, @PathVariable("code") int eventCode) {
        return repository.findById(eventCode)
                .map(event -> {
                    event.setEventName(eventDto.getEventName());
                    event.setEventType(eventDto.getEventType());
                    event.setDescription(eventDto.getDescription());
                    event.setDuration(eventDto.getDuration());

                    StudentGroup group = studentGroupRepository.findById(eventDto.getGroupId()).orElseThrow(
                            () -> new StudentGroupNotFoundException(eventDto.getGroupId()));
                    event.setStudentGroup(group);

                    Room room = roomRepository.findById(eventDto.getRoomCode()).orElseThrow(
                            () -> new RoomNotFoundException(eventDto.getRoomCode()));
                    event.setRoom(room);

                    String date = eventDto.getDate();
                    event.setDate(date);

                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    //sdf.setLenient(true);
                    //String dateStr = eventDto.getDate();
                    //Date newDate = sdf.parse(dateStr, new ParsePosition(0));
                    //event.setDate(newDate);

                    // make sure capacity is at or below room capacity
                    int capacity = eventDto.getEventCapacity();
                    if (capacity > room.getCapacity()) {
                        capacity = room.getCapacity();
                        event.setEventCapacity(capacity);
                    }
                    else {
                        event.setEventCapacity(capacity);
                    }

                    return repository.save(event);
                })
                .orElseGet(() -> {
                    Event newEvent = new Event();
                    newEvent.setEventCode(eventCode);
                    newEvent.setEventName(eventDto.getEventName());
                    newEvent.setEventType(eventDto.getEventType());
                    newEvent.setDescription(eventDto.getDescription());
                    newEvent.setDuration(eventDto.getDuration());

                    StudentGroup group = studentGroupRepository.findById(eventDto.getGroupId()).orElseThrow(
                            () -> new StudentGroupNotFoundException(eventDto.getGroupId()));
                    newEvent.setStudentGroup(group);

                    Room room = roomRepository.findById(eventDto.getRoomCode()).orElseThrow(
                            () -> new RoomNotFoundException(eventDto.getRoomCode()));
                    newEvent.setRoom(room);

                    String date = eventDto.getDate();
                    newEvent.setDate(date);

                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    //try {
                    //    Date date = sdf.parse(eventDto.getDate());
                    //    newEvent.setDate(date);
                    //} catch (ParseException e) {
                    //    throw new RuntimeException(e);
                    //}

                    // make sure capacity is at or below room capacity
                    int capacity = eventDto.getEventCapacity();
                    if (capacity > room.getCapacity()) {
                        capacity = room.getCapacity();
                        newEvent.setEventCapacity(capacity);
                    }
                    else {
                        newEvent.setEventCapacity(capacity);
                    }
                    return repository.save(newEvent);
                });
    }

    // DELETE EVENT
        // ADMIN ONLY
    @DeleteMapping("/events/{code}")
    void deleteEvent(@PathVariable("code") int eventCode) {
//        //Need to delete all rsvps before being able to delete event (also applies to students) ///////////////////////////////////////////////////////////
//        List<Long> allStudentIds = studentRepository.studentIds();
//
//        for(int i = 0; i < allStudentIds.size(); i++)
//        {
//            //Make rsvp key w student id and event code
//
////            RSVPDto rsvpDto = new RSVPDto();
////            rsvpDto.setStudentId(123456L); // Set the student ID
////            rsvpDto.setEventCode(1); // Set the event code
//
//            //replace first allStudentIds with list of student ids from rsvp list
//            if(allStudentIds.contains(allStudentIds.get(i)))
//            {
//                //Set up RSVP key, then delete
//                RSVPKey tempRSVPKey = new RSVPKey(allStudentIds.get(i), eventCode);
//                RSVP tempRSVP = new RSVP();
//                tempRSVP.setRsvpKey(tempRSVPKey);
//                //RSVPController(rsvpRepository).deleteRSVP(eventCode, studentIds[i]);
//                rsvpRepository.deleteById(tempRSVPKey);
//                //rsvpRepository.
//            }
////            rsvpController
////            RSVPController(rsvpRepository).deleteRSVP(eventCode, allStudentIDs[i]);
//        }

        List<Long> studentRSVP = repository.findRsvpEvent(eventCode);

        if (!studentRSVP.isEmpty())
        {
            for (Long studentId : studentRSVP)
            {
                RSVPKey key = new RSVPKey(studentId, eventCode);
                rsvpRepository.deleteById(key);
            }
        }

        repository.deleteById(eventCode);
    }
}
