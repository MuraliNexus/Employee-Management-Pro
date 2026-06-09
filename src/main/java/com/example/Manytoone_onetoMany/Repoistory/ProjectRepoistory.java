package com.example.Manytoone_onetoMany.Repoistory;

import com.example.Manytoone_onetoMany.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepoistory extends JpaRepository<Project,Long> {

}
