package com.java.vaccnow.service;

import com.java.vaccnow.constants.BranchManagementConstants;
import com.java.vaccnow.dao.BranchDao;
import com.java.vaccnow.entity.Branch;
import com.java.vaccnow.exception.DataAlreadyExistsException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

  @Autowired
  private BranchDao branchDao;

  public List<Branch> getBranches(Branch branch) {
    return branchDao.getBranches(branch);
  }

  public void save(Branch branch) {
    branchDao.save(branch);
  }

  public void update(Branch branch) throws DataAlreadyExistsException {
    Optional<Branch> branchÒptional = branchDao.findByName(branch.getName());
    if (branchÒptional.isPresent()) {
      Branch branchDb = branchÒptional.get();
      if (branchDb.getId() != branch.getId()) {
        throw new DataAlreadyExistsException(
            BranchManagementConstants.DATA_ALREADY_EXISTS_EXCEPTION);
      }
    }
    branchDao.save(branch);
  }
}
