package com.java.vaccnow.service;

import com.java.vaccnow.dao.BranchAvailabilityDao;
import com.java.vaccnow.entity.BranchAvailability;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchAvailabilityService {

  @Autowired
  private BranchAvailabilityDao branchAvailabilityDao;

  /**
   * This method retrieves Branch Availability.
   * @param branchAvailability - BranchAvailability
   * @return - List
   */
  public List<BranchAvailability> getBranchAvailability(BranchAvailability branchAvailability) {
    return branchAvailabilityDao.getBranchAvailability(branchAvailability);
  }

  public void save(BranchAvailability branchAvailability) {
    branchAvailabilityDao.save(branchAvailability);
  }

  public void delete(BranchAvailability branchAvailability) {
    branchAvailabilityDao.delete(branchAvailability);
  }

  public void update(BranchAvailability branchAvailability) {
    Optional<BranchAvailability> branchAvailabilityOptional =
        branchAvailabilityDao.findById(branchAvailability.getId());
    if (branchAvailabilityOptional.isPresent()) {
      BranchAvailability branchAvailabilityDb = branchAvailabilityOptional.get();
      branchAvailability.setStartTime(branchAvailability.getStartTime());
      branchAvailability.setEndTime(branchAvailability.getEndTime());
      branchAvailabilityDao.save(branchAvailabilityDb);
    }
  }
}
