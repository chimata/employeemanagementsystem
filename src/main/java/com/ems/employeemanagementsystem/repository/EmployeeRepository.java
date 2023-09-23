package com.ems.employeemanagementsystem.repository;

import com.ems.employeemanagementsystem.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anji Chimata
 */
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
