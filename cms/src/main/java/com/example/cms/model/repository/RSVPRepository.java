package com.example.cms.model.repository;

import com.example.cms.model.entity.RSVP;
import com.example.cms.model.entity.RSVPKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// NEEDS COMPLETING //
@Repository
public interface RSVPRepository extends JpaRepository<RSVP, RSVPKey> {
}
