package com.example.cms;

import com.example.cms.controller.exceptions.EventNotFoundException;
import com.example.cms.model.entity.Event;
import com.example.cms.model.entity.Room;
import com.example.cms.model.entity.StudentGroup;
import com.example.cms.model.repository.EventRepository;
import com.example.cms.model.repository.RoomRepository;
import com.example.cms.model.repository.StudentGroupRepository;
import com.example.cms.model.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;


    @Test
    void getAllEvents() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/events")).andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }


    @Test
    void getEvent() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/events/2"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(2, receivedJson.get("eventCode").intValue());
        assertEquals("Origami Workshop", receivedJson.get("eventName").textValue());
        assertEquals(3007, receivedJson.get("studentGroup").get("groupId").intValue());
        assertEquals("SS1086", receivedJson.get("room").get("roomCode").textValue());
        assertEquals("2023/12/01 16:00:01", receivedJson.get("date").textValue());
        assertEquals(2, receivedJson.get("duration").floatValue());
        assertEquals("Drop in and fold origami!", receivedJson.get("description").textValue());
        assertEquals("Arts", receivedJson.get("eventType").textValue());
        assertEquals(60, receivedJson.get("eventCapacity").intValue());

    }

    @Test
    void addEvent() throws Exception {
        ObjectNode eventJson = objectMapper.createObjectNode();
        eventJson.put("eventCode", 99);
        eventJson.put("eventName", "Drop-In Basketball");
        eventJson.put("groupId", 3011);
        eventJson.put("roomCode", "AC101");
        eventJson.put("date", "2023/12/01 14:00:01");
        eventJson.put("duration", 4);
        eventJson.put("description", "play drop-in basketball");
        eventJson.put("eventType", "Athletic");
        eventJson.put("eventCapacity", 60);

        MockHttpServletResponse response = mockMvc.perform(
                        post("/events").
                                contentType("application/json").
                                content(eventJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        assertTrue(eventRepository.findById(99).isPresent());
        Event addedEvent = eventRepository.findById(99).get();

        assertEquals(99, addedEvent.getEventCode());
        assertEquals("Drop-In Basketball", addedEvent.getEventName());
        assertEquals(3011, addedEvent.getStudentGroup().getGroupId());
        assertEquals("AC101", addedEvent.getRoom().getRoomCode());
        assertEquals("2023/12/01 14:00:01", addedEvent.getDate());
        assertEquals(4, addedEvent.getDuration());
        assertEquals("play drop-in basketball", addedEvent.getDescription());
        assertEquals("Athletic", addedEvent.getEventType());
        assertEquals(50, addedEvent.getEventCapacity());
    }

    @Test
    void editEvent() throws Exception {
        ObjectNode eventJson = objectMapper.createObjectNode();
        eventJson.put("eventCode", 1);
        eventJson.put("eventName", "Drop-In Pickleball");
        eventJson.put("groupId", 3006);
        eventJson.put("roomCode", "HH010");
        eventJson.put("date", "2023/12/01 14:00:01");
        eventJson.put("duration", 2);
        eventJson.put("description", "Visit the fitness information desk to collect a wristband to play");
        eventJson.put("eventType", "Athletic");
        eventJson.put("eventCapacity", 16);

        // (1, 'Pickleball', 3006, 'HH010', '2023-11-23', 1.33, 'Visit the fitness information desk to collect a wristband to play', 'Athletic', 16);


        MockHttpServletResponse response = mockMvc.perform(
                        put("/events/1").
                                contentType("application/json").
                                content(eventJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        assertTrue(eventRepository.findById(1).isPresent());
        Event addedEvent = eventRepository.findById(1).get();

        assertEquals(1, addedEvent.getEventCode());
        assertEquals("Drop-In Pickleball", addedEvent.getEventName());
        assertEquals(3006, addedEvent.getStudentGroup().getGroupId());
        assertEquals("HH010", addedEvent.getRoom().getRoomCode());
        assertEquals("2023/12/01 14:00:01", addedEvent.getDate());
        assertEquals(2, addedEvent.getDuration());
        assertEquals("Visit the fitness information desk to collect a wristband to play", addedEvent.getDescription());
        assertEquals("Athletic", addedEvent.getEventType());
        assertEquals(16, addedEvent.getEventCapacity());
    }

    @Test
    void deleteEvent() throws Exception {
        Event e = new Event();
        e.setEventCode(99);
        e.setEventName("Tennis");
        StudentGroup s = studentGroupRepository.findById(3011).get();
        e.setStudentGroup(s);
        Room r = roomRepository.findById("AC102").get();
        e.setRoom(r);
        e.setDate("2023/12/05 18:00:01");
        e.setDuration(4);
        e.setDescription("play tennis with friends!");
        e.setEventType("Athletic");
        e.setEventCapacity(8);
        eventRepository.save(e);

        MockHttpServletResponse response = mockMvc.perform(
                delete("/events/99").
                        contentType("applications/json"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(eventRepository.findById(99).isEmpty());

    }

//    (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity)
}
