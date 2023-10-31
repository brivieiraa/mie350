package com.example.cms.model.repository;

import com.example.cms.model.entity.Event;
import com.example.cms.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// NEEDS COMPLETING //
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
