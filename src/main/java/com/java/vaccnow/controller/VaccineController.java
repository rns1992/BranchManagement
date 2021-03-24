package com.java.vaccnow.controller;

import com.java.vaccnow.entity.Vaccine;
import com.java.vaccnow.entity.VaccineByBranch;
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
 * Spring Boot Controller for Vaccine Details.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/vaccine")
public class VaccineController {

  /**
   * LOGGER API for logging.
   */
  public static final Logger LOGGER = LoggerFactory.getLogger(Vaccine.class);

  @Autowired
  private VaccineService vaccineService;

  @GetMapping
  public ResponseEntity<Vaccine> getVaccines(
      @RequestParam(value = "id", required = false) Long id) {
    Vaccine vaccine = Vaccine.builder().id(id).build();
    List<Vaccine> vaccineByBranches = vaccineService.getVaccines(vaccine);
    return new ResponseEntity(vaccineByBranches, HttpStatus.OK);
  }

}
