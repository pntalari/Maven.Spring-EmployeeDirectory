package io.zipcoder.persistenceapp.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long departmentNumber;
  private String departmentName;

  @Autowired
  private EmployeeEntity manager;

  @Autowired
  private EmployeeEntity employee;


}
