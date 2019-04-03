package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Long> {
}
