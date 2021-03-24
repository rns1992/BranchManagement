package com.java.vaccnow.repository;

import com.java.vaccnow.entity.Vaccine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVaccineRepository extends JpaRepository<Vaccine, Long> {
}
