package com.example.cms.model.repository;

import com.example.cms.model.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// NEEDS COMPLETING //
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
}
