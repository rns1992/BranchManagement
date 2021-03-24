package com.java.vaccnow.repository;

import com.java.vaccnow.entity.Branch;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranchRepository extends JpaRepository<Branch, Long> {

  Optional<Branch> findByName(String name);
}
