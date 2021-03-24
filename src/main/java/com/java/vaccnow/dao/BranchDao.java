package com.java.vaccnow.dao;

import com.java.vaccnow.entity.Branch;
import com.java.vaccnow.repository.IBranchRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class BranchDao {

  @Autowired
  private IBranchRepository branchRepository;

  public List<Branch> getBranches(Branch branch) {
    return branchRepository.findAll(Example.of(branch));
  }

  public void save(Branch branch) {
    branchRepository.save(branch);
  }

  public Optional<Branch> findByName(String name) {
    return branchRepository.findByName(name);
  }
}
