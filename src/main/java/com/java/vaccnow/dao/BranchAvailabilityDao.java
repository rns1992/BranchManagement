package com.java.vaccnow.dao;

import com.java.vaccnow.entity.BranchAvailability;
import com.java.vaccnow.repository.IBranchAvailabilityRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class BranchAvailabilityDao {

  @Autowired
  private IBranchAvailabilityRepository branchAvailabilityRepository;

  public List<BranchAvailability> getBranchAvailability(BranchAvailability branchAvailability) {
    return branchAvailabilityRepository.findAll(Example.of(branchAvailability));
  }

  public void save(BranchAvailability branchAvailability) {
    branchAvailabilityRepository.save(branchAvailability);
  }

  public void delete(BranchAvailability branchAvailability) {
    branchAvailabilityRepository.delete(branchAvailability);
  }

  public Optional<BranchAvailability> findById(Long id) {
    return branchAvailabilityRepository.findById(id);
  }
}
