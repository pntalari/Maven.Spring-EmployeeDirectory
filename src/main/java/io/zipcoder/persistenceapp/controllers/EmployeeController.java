package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.DepartmentEntity;
import io.zipcoder.persistenceapp.entities.EmployeeEntity;
import io.zipcoder.persistenceapp.services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {

  private Services services;

  public EmployeeController(Services services) {
    this.services = services;
  }

  @GetMapping("/API/")
  public ResponseEntity<Iterable<EmployeeEntity>> findall() {
    return new ResponseEntity<>(services.getAllEmployees(), HttpStatus.OK);
  }

  @GetMapping("/API/{department}")
  public ResponseEntity<Iterable<EmployeeEntity>> findEmpByDept(@PathVariable DepartmentEntity department) {
    return new ResponseEntity<>(this.services.getEmployeesByDept(department), HttpStatus.OK);
  }

  @PostMapping("/API/")
  public ResponseEntity<EmployeeEntity> createEmpl(@RequestBody EmployeeEntity employee, @RequestBody DepartmentEntity department) {
    return new ResponseEntity<>(this.services.createEmployee(employee, department), HttpStatus.CREATED);
  }

  @DeleteMapping("/API/{employee}")
  public ResponseEntity<Boolean> deleteEmpl(@PathVariable EmployeeEntity employee) {
    return new ResponseEntity<>(this.services.deleteOneEmpl(employee),HttpStatus.OK);
  }



}
