package com.java.vaccnow.validations;

import com.java.vaccnow.constants.BranchManagementConstants;
import com.java.vaccnow.entity.Branch;
import com.java.vaccnow.entity.BranchAvailability;
import com.java.vaccnow.exception.InvalidInputException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomValidations {

  /**
   * Validate Branch Availability required parameters.
   *
   * @param branchAvailability -
   *
   * @throws InvalidInputException - thrown when required input is missing.
   */
  public void validateCreateBranchAvailability(BranchAvailability branchAvailability)
      throws InvalidInputException {
    if (branchAvailability.getBranchId() == null || branchAvailability.getVaccineId() == null
        || branchAvailability.getStartTime() == null || branchAvailability.getEndTime() == null) {
      throw new InvalidInputException(BranchManagementConstants.INVALID_INPUT_EXCEPTION);
    }
  }

  public void validateBranch(Branch branch) throws InvalidInputException {
    if (!StringUtils.hasText(branch.getName())) {
      throw new InvalidInputException(BranchManagementConstants.INVALID_INPUT_EXCEPTION);
    }
  }

  public void validateBranchUpdate(Branch branch) throws InvalidInputException {
    if (!StringUtils.hasText(branch.getName()) && branch.getId() != null) {
      throw new InvalidInputException(BranchManagementConstants.INVALID_INPUT_EXCEPTION);
    }
  }
}
