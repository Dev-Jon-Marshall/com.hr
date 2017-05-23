package com.astontech.hr.repositories;

import com.astontech.hr.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
