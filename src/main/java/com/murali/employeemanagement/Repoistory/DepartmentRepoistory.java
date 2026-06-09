package com.murali.employeemanagement.Repoistory;

import com.murali.employeemanagement.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepoistory extends JpaRepository<Department,Long> {


}
