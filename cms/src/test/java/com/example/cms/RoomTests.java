package com.example.cms;

import com.fasterxml.jackson.core.type.TypeReference;
import com.example.cms.model.entity.Room;
import com.example.cms.model.repository.RoomRepository;
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


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void getRoom() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/classrooms/code/HH010"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals("HH010", receivedJson.get("roomCode").textValue());
        assertEquals("Hart House", receivedJson.get("building").textValue());
        assertEquals(105, receivedJson.get("capacity").intValue());
    }

    void getListRoomsByBuilding() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/classrooms/building/Hart House"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals("HH010", receivedJson.get("roomCode").textValue());
        assertEquals("Hart House", receivedJson.get("building").textValue());
        assertEquals(105, receivedJson.get("capacity").intValue());
    }

    @Test
    void getListOfRoomsByBuilding() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/classrooms/building/Hart House"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        List<Room> receivedRooms = objectMapper.readValue(
                response.getContentAsString(),
                new TypeReference<List<Room>>() {}
        );
        // Check the number of rooms retrieved for "Hart House"
        assertEquals(3, receivedRooms.size()); // Expecting 3 rooms for "Hart House"

        // Validate details of the first room in the list
        Room firstRoom = receivedRooms.get(0);
        assertEquals("HH010", firstRoom.getRoomCode());
        assertEquals("Hart House", firstRoom.getBuilding());
        assertEquals("Gymnasium", firstRoom.getRoomType());
        assertEquals(105, firstRoom.getCapacity());
    }

    @Test
    void getListOfRoomsWithCapacity() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/classrooms/capacity/" + 50))
                .andReturn().getResponse();

        // Assert the response status code is OK (200)
        assertEquals(200, response.getStatus());

        // Deserialize the JSON response to a List of Room objects
        List<Room> receivedRooms = objectMapper.readValue(
                response.getContentAsString(),
                new TypeReference<List<Room>>() {}
        );

        // Assert that the list is not empty
        assertFalse(receivedRooms.isEmpty());

        // Assert that all rooms in the received list have the expected capacity
        assertTrue(receivedRooms.stream().allMatch(room -> room.getCapacity() == 50));

        // check if a specific room known to have the capacity of 105 is in the list
        assertTrue(receivedRooms.stream().anyMatch(room -> "AC101".equals(room.getRoomCode())));
    }





}
