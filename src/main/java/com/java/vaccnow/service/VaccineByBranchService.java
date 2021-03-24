package com.java.vaccnow.service;

import com.java.vaccnow.dao.VaccineByBranchDao;
import com.java.vaccnow.entity.VaccineByBranch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineByBranchService {

  @Autowired
  private VaccineByBranchDao vaccineByBranchDao;

  public List<VaccineByBranch> getVaccinesByBranch(VaccineByBranch vaccineByBranch) {
    return vaccineByBranchDao.getVaccineByBranch(vaccineByBranch);
  }

}
