package io.zipcoder.persistenceapp.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
//@Table(name = "employee", catalog = "Employee_Directory")
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column(name = "emp_num")
  private Long employeeNumber;
 // @Column(name = "first_name")
  private String firstName;
//  @Column(name = "last_name")
  private String lastName;
 // @Column(name = "title")
  private String title;
//  @Column(name = "phone_num")
  private String phoneNumber;
//  @Column(name = "email")
  private String email;
//  @Column(name = "hire_date")
  private Date hireDate;


  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "departmentNumber")
  @Autowired
  private DepartmentEntity emplDept;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "departmentNumber")
  @Autowired
  private DepartmentEntity managerDept;

  public EmployeeEntity() {
  }

  public EmployeeEntity(String firstName, String lastName, String title, String phoneNumber, String email, Date hireDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.hireDate = hireDate;
  }

  public Long getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Long employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public DepartmentEntity getDepartmentNumber() {
    return emplDept;
  }

  public void setDepartmentNumber(DepartmentEntity departmentNumber) {
    this.emplDept = departmentNumber;
  }

  public DepartmentEntity getEmplDept() {
    return emplDept;
  }

  public void setEmplDept(DepartmentEntity emplDept) {
    this.emplDept = emplDept;
  }

  public DepartmentEntity getManagerDept() {
    return managerDept;
  }

  public void setManagerDept(DepartmentEntity managerDept) {
    this.managerDept = managerDept;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EmployeeEntity that = (EmployeeEntity) o;
    return employeeNumber.equals(that.employeeNumber) &&
      Objects.equals(firstName, that.firstName) &&
      Objects.equals(lastName, that.lastName) &&
      Objects.equals(title, that.title) &&
      Objects.equals(phoneNumber, that.phoneNumber) &&
      Objects.equals(email, that.email) &&
      Objects.equals(hireDate, that.hireDate) &&
      emplDept.equals(that.emplDept) &&
      managerDept.equals(that.managerDept);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeNumber, firstName, lastName, title, phoneNumber, email, hireDate, emplDept, managerDept);
  }

  @Override
  public String toString() {
    return "EmployeeEntity{" +
      "employeeNumber=" + employeeNumber +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", title='" + title + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", email='" + email + '\'' +
      ", hireDate=" + hireDate +
      ", emplDept=" + emplDept +
      ", managerDept=" + managerDept +
      '}';
  }
}
