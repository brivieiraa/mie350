package com.example.cms.model.repository;

import com.example.cms.model.entity.Event;
import com.example.cms.model.entity.Event;
import com.example.cms.model.entity.RSVP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// NEEDS COMPLETING //
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value = "select studentId from rsvps where eventCode = :code", nativeQuery = true)
    List<Long> findRsvpEvent(@Param("code") int eventCode);

    @Query(value = "SELECT * FROM events " +
            "WHERE eventCode IN" +
            "(SELECT eventCode FROM rsvps WHERE studentId = :studentId)", nativeQuery = true)
    List<Event> findStudentEventsByStudentId(@Param("studentId") long studentId);
}
