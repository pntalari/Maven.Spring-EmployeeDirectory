package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.DepartmentEntity;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;
    private EmployeeRepository emplyRepo;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.deptRepo = departmentRepository;
    }

    // Create a Department
    public DepartmentEntity createDept(DepartmentEntity department){
        return deptRepo.save(department);
    }

    // Change the name of a department
    public DepartmentEntity updateName(Long departmentNum, DepartmentEntity departmentEntity){
        DepartmentEntity originalDepartment = deptRepo.findOne(departmentNum);
        originalDepartment.setDepartmentName(departmentEntity.getDepartmentName());

        return deptRepo.save(originalDepartment);
    }

    // Remove all employees from a particular department
    public Boolean deleteAllEmployees(DepartmentEntity department) {

//        List<EmployeeEntity> empList = StreamSupport.stream(iterable.splitIterator(),false)
//                .collect(Collectors.toList());


        return false;
    }


}
