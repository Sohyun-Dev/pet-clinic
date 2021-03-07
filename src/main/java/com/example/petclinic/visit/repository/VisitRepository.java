package com.example.petclinic.visit.repository;

import com.example.petclinic.visit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
