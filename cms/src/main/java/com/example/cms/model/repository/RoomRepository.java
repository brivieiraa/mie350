package com.example.cms.model.repository;

import com.example.cms.model.entity.Room;
import com.example.cms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// NEEDS COMPLETING //
@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    @Query(value = "select * from rooms where :searchTerm = rooms.building", nativeQuery = true)
    List<Room> searchRoomsInBuilding(@Param("searchTerm") String searchTerm);

    @Query(value = "select * from rooms where :searchTerm2 = rooms.capacity", nativeQuery = true)
    List<Room> searchRoomsByCapacity(@Param("searchTerm2") int searchTerm2);



}
