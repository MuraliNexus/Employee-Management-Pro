package com.example.Manytoone_onetoMany.Repoistory;

import com.example.Manytoone_onetoMany.Entity.Address;
import com.example.Manytoone_onetoMany.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepoistory extends JpaRepository<Address,Long> {

}
