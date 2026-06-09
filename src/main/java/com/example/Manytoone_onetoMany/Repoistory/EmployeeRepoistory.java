package com.example.Manytoone_onetoMany.Repoistory;

import com.example.Manytoone_onetoMany.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepoistory extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

}
