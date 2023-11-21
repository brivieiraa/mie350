package com.example.cms;

import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.RSVPRepository;
import com.example.cms.model.repository.StudentGroupRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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



}
