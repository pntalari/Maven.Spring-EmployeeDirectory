package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
}
