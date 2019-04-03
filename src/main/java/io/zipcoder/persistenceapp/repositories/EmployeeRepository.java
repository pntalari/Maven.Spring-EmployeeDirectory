package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
}
