package com.java.vaccnow.dao;

import com.java.vaccnow.entity.VaccineByBranch;
import com.java.vaccnow.repository.IVaccineByBranchRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class VaccineByBranchDao {

  @Autowired
  private IVaccineByBranchRepository vaccineByBranchRepository;

  public List<VaccineByBranch> getVaccineByBranch(VaccineByBranch vaccineByBranch) {
    return vaccineByBranchRepository.findAll(Example.of(vaccineByBranch));
  }

}
