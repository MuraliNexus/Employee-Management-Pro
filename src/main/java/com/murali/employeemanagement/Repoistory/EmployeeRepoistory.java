package com.murali.employeemanagement.Repoistory;

import com.murali.employeemanagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepoistory extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

}
