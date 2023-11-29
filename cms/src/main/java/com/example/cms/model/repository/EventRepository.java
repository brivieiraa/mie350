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

    @Query(value = "select * from rsvps where studentId = :id", nativeQuery = true)
    List<RSVP> findRsvpStudent(@Param("id") long studentId);

    @Query(value = "select * from rsvps where eventCode = :code", nativeQuery = true)
    List<RSVP> findRsvpEvent(@Param("code") int eventCode);

}
