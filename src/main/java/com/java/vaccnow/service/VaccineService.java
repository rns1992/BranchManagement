package com.java.vaccnow.service;

import com.java.vaccnow.dao.VaccineDao;
import com.java.vaccnow.entity.Vaccine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {

  @Autowired
  private VaccineDao vaccineDao;

  public List<Vaccine> getVaccines(Vaccine vaccine) {
    return vaccineDao.getVaccines(vaccine);
  }

}
