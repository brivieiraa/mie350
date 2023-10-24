package com.example.cms.model.repository;

import com.example.cms.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// NEEDS COMPLETING //
@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
}
