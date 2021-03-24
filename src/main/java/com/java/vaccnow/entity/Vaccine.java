package com.java.vaccnow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vaccine")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

}
