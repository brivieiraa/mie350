package com.example.cms.model.repository;

import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import com.example.cms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// NEEDS COMPLETING //
@Repository
public interface RSVPRepository extends JpaRepository<RSVP, RSVPKey> {

    @Query(value = "select s.id from students s where " +
            "id IN (SELECT s.id FROM STUDENTS s INNER JOIN MARKS m ON s.id = m.studentID " +
            "group by s.id HAVING AVG(Mark) >= 90)", nativeQuery = true)
    List<Student> findTopStudents();
}
