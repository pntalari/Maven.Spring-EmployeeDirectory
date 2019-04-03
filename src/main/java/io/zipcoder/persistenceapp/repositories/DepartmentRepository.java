package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.entities.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Long> {
}
