package com.example.cms.model.repository;

import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import com.example.cms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// NEEDS COMPLETING //
@Repository
public interface RSVPRepository extends JpaRepository<RSVP, RSVPKey> {

    @Query(value = "SELECT eventCode from rsvps r " +
            "WHERE r.studentId = :studentID", nativeQuery = true)
    List<Integer> findRSVPbyStudent(@Param("studentID") Long studentID);
}
