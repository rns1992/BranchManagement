package com.java.vaccnow.repository;

import com.java.vaccnow.entity.Branch;
import com.java.vaccnow.entity.BranchAvailability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranchAvailabilityRepository extends JpaRepository<BranchAvailability, Long> {
}
