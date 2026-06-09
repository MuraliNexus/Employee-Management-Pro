package com.murali.employeemanagement.Repoistory;

import com.murali.employeemanagement.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepoistory extends JpaRepository<Project,Long> {

}
