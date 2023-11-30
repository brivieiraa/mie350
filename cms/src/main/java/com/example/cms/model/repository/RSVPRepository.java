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

    //Get list of students registered for specific event
    @Query(value = "select s.id from students s where " +
            "id IN (SELECT s.id FROM STUDENTS s INNER JOIN MARKS m ON s.id = m.studentID " +
            "group by s.id HAVING AVG(Mark) >= 90)", nativeQuery = true)
    List<Student> findTopStudents();

    @Query(value = "SELECT eventCode from rsvps r " +
            "WHERE r.studentId = :studentID", nativeQuery = true)
    List<Integer> findRSVPbyStudent(@Param("studentID") Long studentID);
}
