package com.java.vaccnow.controller;

import com.java.vaccnow.entity.BranchAvailability;
import com.java.vaccnow.exception.InvalidInputException;
import com.java.vaccnow.service.BranchAvailabilityService;
import com.java.vaccnow.validations.CustomValidations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Controller for Branch Availability Details.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/branchAvailability")
public class BranchAvailabilityController {

  @Autowired
  private BranchAvailabilityService branchAvailabilityService;

  @Autowired
  private CustomValidations customValidations;

  /**
   * API to retrieve Branch Availability.
   * @param branchId - Id of Branch
   * @param vaccineId - Id of Vaccine
   * @return - BranchAvailability
   */
  @GetMapping
  public ResponseEntity<BranchAvailability> getBranchAvailability(
      @RequestParam(value = "branchId", required = false) Long branchId,
      @RequestParam(value = "vaccineId", required = false) Long vaccineId) {
    BranchAvailability branchAvailability = BranchAvailability.builder()
        .branchId(branchId).vaccineId(vaccineId).build();
    List<BranchAvailability> vaccineByBranches = branchAvailabilityService
        .getBranchAvailability(branchAvailability);
    return new ResponseEntity(vaccineByBranches, HttpStatus.OK);
  }

  /**
   * API to create BranchAvailability.
   * @param branchAvailability - Details of BranchAvailability.
   * @return - BranchAvailability
   * @throws InvalidInputException - thrown when required params are missing.
   */
  @PostMapping
  public ResponseEntity<BranchAvailability> create(
      @RequestBody BranchAvailability branchAvailability) throws InvalidInputException {
    customValidations.validateCreateBranchAvailability(branchAvailability);
    branchAvailabilityService.save(branchAvailability);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * API to delete BranchAvailability entity by Id.
   * @param id - Id of BranchAvailability.
   * @return - BranchAvailability
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<BranchAvailability> delete(
      @PathVariable(value = "id", required = true) long id) {
    BranchAvailability branchAvailability = BranchAvailability.builder().id(id).build();
    branchAvailabilityService.delete(branchAvailability);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * API to update start and end time.
   * @param id - Id of BranchAvailability.
   * @return - BranchAvailability
   */
  @PatchMapping("/updateTime")
  public ResponseEntity<BranchAvailability> updateTime(
      @PathVariable(value = "id", required = true) long id) {
    BranchAvailability branchAvailability = BranchAvailability.builder().id(id).build();
    branchAvailabilityService.update(branchAvailability);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
