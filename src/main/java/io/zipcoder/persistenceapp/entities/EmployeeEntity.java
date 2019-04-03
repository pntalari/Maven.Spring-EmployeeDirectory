package io.zipcoder.persistenceapp.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long employeeNumber;
  private String firstName;
  private String lastName;
  private String title;
  private String phoneNumber;
  private String email;
  private Date hireDate;

  @Autowired
  private Long departmentNumber;



}
