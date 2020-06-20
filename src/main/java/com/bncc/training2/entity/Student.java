package com.bncc.training2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstname;

  private String surname;

  @OneToOne
  private Major major;

  @ManyToOne
  private StudentClass studentClass;

}
