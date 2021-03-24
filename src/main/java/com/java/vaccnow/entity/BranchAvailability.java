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
@Table(name = "branch_availability")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchAvailability {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "branch_id", nullable = false)
  private Long branchId;

  @Column(name = "vaccine_id", nullable = false)
  private Long vaccineId;

  @Column(name = "start_time", nullable = false)
  private Integer startTime;

  @Column(name = "end_time", nullable = false)
  private Integer endTime;

}
