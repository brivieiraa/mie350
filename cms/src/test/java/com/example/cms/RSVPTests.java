package com.example.cms;

import com.example.cms.controller.dto.RSVPDto;
import com.example.cms.model.entity.Event;
import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.EventRepository;
import com.example.cms.model.repository.RSVPRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RSVPTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RSVPRepository rsvpRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EventRepository eventRepository;

    @Test
    void addRSVP() throws Exception{

        ObjectNode RSVPJson = objectMapper.createObjectNode();
        RSVPJson.put("studentId", 1003L);
        RSVPJson.put("eventCode", 1);

        MockHttpServletResponse response = mockMvc.perform(
                        post("/rsvp").
                                contentType("application/json").
                                content(RSVPJson.toString()))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        assertTrue(rsvpRepository.findById(new RSVPKey(1003L,1)).isPresent());
        RSVP addedRSVP = rsvpRepository.findById(new RSVPKey(1003L,1)).get();

        // Assert the details of the students are correct
        assertEquals(1003L, addedRSVP.getStudent().getId());
        assertEquals(1, addedRSVP.getEvent().getEventCode());
        //assertEquals("MIE", addedStudent.getDepartment());
    }

    @Test
    void deleteRSVP() throws Exception {
        // Create a student and save it to the repository
        Student s = new Student();
        s.setId(123456L);
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("first@last.com");
        studentRepository.save(s);

        // Create an RSVP record for the student and an event
        RSVPDto rsvpDto = new RSVPDto();
        rsvpDto.setStudentId(123456L); // Set the student ID
        rsvpDto.setEventCode(1); // Set the event code

        // Perform a POST request to create the RSVP record
        mockMvc.perform(
                post("/rsvp")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(rsvpDto))
        ).andExpect(status().isOk()); // Check if the request was successful

        // Perform a DELETE request to remove the RSVP record
        MockHttpServletResponse response = mockMvc.perform(
                delete("/rsvp/1/123456")
                        .contentType("application/json")
        ).andReturn().getResponse();

        // Assert that the response status is 200 OK
        assertEquals(200, response.getStatus());

        // Assert that the RSVP record is deleted by checking if it's not present in the repository
        assertTrue(rsvpRepository.findById(new RSVPKey(123456L, 1)).isEmpty());
    }








}
