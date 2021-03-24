package com.java.vaccnow.repository;

import com.java.vaccnow.entity.VaccineByBranch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVaccineByBranchRepository extends JpaRepository<VaccineByBranch, Long> {
}
