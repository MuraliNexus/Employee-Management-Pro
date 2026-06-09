package com.example.Manytoone_onetoMany.Repoistory;

import com.example.Manytoone_onetoMany.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepoistory extends JpaRepository<Department,Long> {


}
