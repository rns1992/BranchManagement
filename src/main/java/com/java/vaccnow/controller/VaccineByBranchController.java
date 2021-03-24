package com.java.vaccnow.controller;

import com.java.vaccnow.entity.Vaccine;
import com.java.vaccnow.entity.VaccineByBranch;
import com.java.vaccnow.service.VaccineByBranchService;
import com.java.vaccnow.service.VaccineService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Controller for Vaccine By Branch Details.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/vaccineByBranch")
public class VaccineByBranchController {

  /**
   * LOGGER API for logging.
   */
  public static final Logger LOGGER = LoggerFactory.getLogger(VaccineByBranchController.class);

  @Autowired
  private VaccineByBranchService vaccineByBranchService;

  @GetMapping
  public ResponseEntity<VaccineByBranch> getVaccines(
      @RequestParam(value = "branchId", required = false) Long branchId,
      @RequestParam(value = "vaccineId", required = false) Long vaccineId,
      @RequestParam(value = "id", required = false) Long id) {
    VaccineByBranch vaccineByBranch = VaccineByBranch.builder()
        .branchId(branchId).vaccineId(vaccineId).id(id).build();
    List<VaccineByBranch> vaccineByBranches = vaccineByBranchService
        .getVaccinesByBranch(vaccineByBranch);
    return new ResponseEntity(vaccineByBranches, HttpStatus.OK);
  }

}
