package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

  public List<EmployeeEntity> findAllByDepartmentNumber(Long departmentNumber);

  public List<EmployeeEntity> findAll();
}
