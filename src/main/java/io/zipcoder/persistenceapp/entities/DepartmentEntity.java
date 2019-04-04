package io.zipcoder.persistenceapp.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department", catalog = "Employee_Directory")
public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "dept_num")
  private Long departmentNumber;

  @Column(name = "dept_name")
  private String departmentName;


  @JoinColumn
  @OneToOne(mappedBy = "deptNumber", cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class )
  @Autowired
  private EmployeeEntity manager;

  @OneToMany(mappedBy = "deptNumber", cascade = CascadeType.ALL, targetEntity = EmployeeEntity.class)
  private List<EmployeeEntity> employeesList;


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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DepartmentEntity that = (DepartmentEntity) o;
    return departmentNumber.equals(that.departmentNumber) &&
      Objects.equals(departmentName, that.departmentName) &&
      Objects.equals(manager, that.manager) &&
      Objects.equals(employeesList, that.employeesList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(departmentNumber, departmentName, manager, employeesList);
  }

  @Override
  public String toString() {
    return "DepartmentEntity{" +
      "departmentNumber=" + departmentNumber +
      ", departmentName='" + departmentName + '\'' +
      ", manager=" + manager +
      ", employeesList=" + employeesList+
      '}';
  }
}
