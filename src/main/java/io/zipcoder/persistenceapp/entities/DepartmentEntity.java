package io.zipcoder.persistenceapp.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "EmployeeDirectory")
public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "dept_num")
  private Long departmentNumber;

  @Column(name = "dept_name")
  private String departmentName;

  @Autowired
  @JoinColumn
  @Column(name = "dept_manager")
  @OneToOne(mappedBy = "departmentManager", cascade = CascadeType.ALL)
  private EmployeeEntity manager;

  @OneToMany(mappedBy = "departmentNumber", cascade = CascadeType.ALL)
  private List<EmployeeEntity> employeesList;

  @Autowired
  private EmployeeEntity employee;


  public DepartmentEntity(String departmentName, List<EmployeeEntity> employeesList) {
    this.departmentName = departmentName;
    this.employeesList = employeesList;
  }

  public DepartmentEntity() {
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

  public EmployeeEntity getManager() {
    return manager;
  }

  public void setManager(EmployeeEntity manager) {
    this.manager = manager;
  }

  public List<EmployeeEntity> getEmployeesList() {
    return employeesList;
  }

  public void setEmployeesList(List<EmployeeEntity> employeesList) {
    this.employeesList = employeesList;
  }

  public EmployeeEntity getEmployee() {
    return employee;
  }

  public void setEmployee(EmployeeEntity employee) {
    this.employee = employee;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DepartmentEntity that = (DepartmentEntity) o;
    return departmentNumber.equals(that.departmentNumber) &&
      Objects.equals(departmentName, that.departmentName) &&
      Objects.equals(manager, that.manager) &&
      Objects.equals(employeesList, that.employeesList) &&
      Objects.equals(employee, that.employee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(departmentNumber, departmentName, manager, employeesList, employee);
  }

  @Override
  public String toString() {
    return "DepartmentEntity{" +
      "departmentNumber=" + departmentNumber +
      ", departmentName='" + departmentName + '\'' +
      ", manager=" + manager +
      ", employeesList=" + employeesList +
      ", employee=" + employee +
      '}';
  }
}
