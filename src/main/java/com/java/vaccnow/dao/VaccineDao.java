package com.java.vaccnow.dao;

import com.java.vaccnow.entity.Vaccine;
import com.java.vaccnow.repository.IVaccineRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class VaccineDao {

  @Autowired
  private IVaccineRepository vaccineRepository;

  public List<Vaccine> getVaccines(Vaccine vaccine) {
    return vaccineRepository.findAll(Example.of(vaccine));
  }

}
