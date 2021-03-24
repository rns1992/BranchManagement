package com.java.vaccnow.controller;

import com.java.vaccnow.entity.Branch;
import com.java.vaccnow.entity.BranchAvailability;
import com.java.vaccnow.entity.VaccineByBranch;
import com.java.vaccnow.exception.DataAlreadyExistsException;
import com.java.vaccnow.exception.InvalidInputException;
import com.java.vaccnow.service.BranchService;
import com.java.vaccnow.validations.CustomValidations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Controller for Branch Details.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/branch")
public class BranchInformationController {

  /**
   * LOGGER API for logging.
   */
  public static final Logger LOGGER = LoggerFactory.getLogger(BranchInformationController.class);

  @Autowired
  private BranchService branchService;

  @Autowired
  private CustomValidations customValidations;

  /**
   * API to Get List of branches.
   *
   * @param id - Branch Id.
   *
   * @return - Branch
   */
  @GetMapping
  public ResponseEntity<Branch> getBranch(
      @RequestParam(value = "id", required = true) Long id) {
    Branch branchDto = Branch.builder().id(id).build();
    List<Branch> branchDtoList = branchService.getBranches(branchDto);
    return new ResponseEntity(branchDtoList, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<HttpStatus> createBranch(@RequestBody Branch branch)
      throws InvalidInputException {
    customValidations.validateBranch(branch);
    branchService.save(branch);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @PatchMapping
  public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch)
      throws InvalidInputException, DataAlreadyExistsException {
    customValidations.validateBranchUpdate(branch);
    branchService.update(branch);
    return new ResponseEntity(HttpStatus.OK);
  }

}
