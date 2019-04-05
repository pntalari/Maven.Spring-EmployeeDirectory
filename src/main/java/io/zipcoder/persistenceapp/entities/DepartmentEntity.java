package io.zipcoder.persistenceapp.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long departmentNumber;
  private String departmentName;
  private Long managerNumber;

  @OneToOne(fetch = FetchType.EAGER, mappedBy = "managerDept", cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class )
  @Autowired
  private EmployeeEntity manager;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "emplDept", cascade = CascadeType.ALL, targetEntity = EmployeeEntity.class)
  private List<EmployeeEntity> employeesList;

  public DepartmentEntity() {
  }

  public DepartmentEntity(String departmentName) {
    this.departmentName = departmentName;
  }

  public DepartmentEntity(String departmentName, List<EmployeeEntity> employeesList) {
    this.departmentName = departmentName;
    this.employeesList = employeesList;
  }

  public Long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(Long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

//  public EmployeeEntity getManager() {
//    return manager;
//  }
//
//  public void setManager(EmployeeEntity manager) {
//    this.manager = manager;
//  }

  public List<EmployeeEntity> getEmployeesList() {
    return employeesList;
  }

  public void setEmployeesList(List<EmployeeEntity> employeesList) {
    this.employeesList = employeesList;
  }

  public Long getManagerNumber() {
    return managerNumber;
  }

  public void setManagerNumber(Long managerNumber) {
    this.managerNumber = managerNumber;
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    DepartmentEntity that = (DepartmentEntity) o;
//    return departmentNumber.equals(that.departmentNumber) &&
//      Objects.equals(departmentName, that.departmentName) &&
//      Objects.equals(manager, that.manager) &&
//      Objects.equals(employeesList, that.employeesList);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(departmentNumber, departmentName, manager, employeesList);
//  }
//
//  @Override
//  public String toString() {
//    return "DepartmentEntity{" +
//      "departmentNumber=" + departmentNumber +
//      ", departmentName='" + departmentName + '\'' +
//      ", manager=" + manager +
//      ", employeesList=" + employeesList +
//      '}';
//  }
}
