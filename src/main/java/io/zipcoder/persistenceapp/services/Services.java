package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.DepartmentEntity;
import io.zipcoder.persistenceapp.entities.EmployeeEntity;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class Services {

    @Autowired
    private EmployeeRepository emplRepo;
    @Autowired
    private DepartmentRepository deptRepo;

    // Constructor
    public Services(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.emplRepo = employeeRepository;
        this.deptRepo = departmentRepository;
    }

    // Create Employee
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return this.emplRepo.save(employee);
    }

    // Create a Department
    public DepartmentEntity createDept(DepartmentEntity department){
        return this.deptRepo.save(department);
    }


    //Get all employees
    public List<EmployeeEntity> getAllEmployees() {
        return this.emplRepo.findAll();
    }

    // Get all employees of a particular department
    public List<EmployeeEntity> getEmployeesByDept(DepartmentEntity department) {
        return this.emplRepo.findAllByDepartmentNumber(department.getDepartmentNumber());
    }

    // Remove a particular employee or list of employees
    public Boolean deleteEmpl(EmployeeEntity... employees) {
        int i = 0;
        Boolean flag = false;
        while (i < employees.length) {
            this.emplRepo.delete(employees[i]);
            flag = true;
        }
        return flag;
    }

    // Change the name of a department
    public DepartmentEntity updateName(Long departmentNum, DepartmentEntity departmentEntity){
        DepartmentEntity originalDepartment = deptRepo.findOne(departmentNum);
        originalDepartment.setDepartmentName(departmentEntity.getDepartmentName());

        return deptRepo.save(originalDepartment);
    }

    // Remove all employees from a particular department
    public Boolean deleteAllEmployeesInDept(Long departmentNumber) {

      List<EmployeeEntity> employees = this.emplRepo.findAllByDepartmentNumber(departmentNumber);
      employees.clear();
    //  this.deptRepo.updateDepartment
//        List<EmployeeEntity> empList = StreamSupport.stream(department..splitIterator(),false)
//                .collect(Collectors.toList());


        return false;
    }


//    Update an employee to set their manager
//    Update other employee fields
//    Set a new department manager (Update department)

//    Get the list of employees under a particular manager

//    Get the entire reporting hierarchy for an employee (their manager + manager's manager etc.)
//            Get a list of employees with no assigned manager

//            Get all employees who report directly or indirectly to a particular manager
//            This should still work for an employee who is not a manager -- they have no direct reports


//            Remove all employees under a particular manager (Including indirect reports)
//    Remove all direct reports to a manager. Any employees previously managed by the deleted employees should now be managed by the next manager up the hierarchy.
//    Get the department, title, or other attributes of a particular employee.
//            Merge departments (given two department names eg: A and B, move the manager of B to report to the manager of A, and update all other employees to be members of department A)
//

}
