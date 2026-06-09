package com.murali.employeemanagement.Specifications;

import com.murali.employeemanagement.Entity.Employee;
import com.murali.employeemanagement.Entity.Project;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecification {

    public static Specification<Employee> getSpecifications(Long id,String name,String deptName,String city,String state,String projectName){
           return new Specification<Employee>() {
               @Override
               public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                   List<Predicate> list = new ArrayList<>();

                   if(id!= null){
                       list.add(criteriaBuilder.equal(root.get("id"),id));
                   }


                   if(name!=null && !name.isEmpty()){
                       System.out.println("Searching Name = " + name);

                       list.add(
                               criteriaBuilder.like(
                                       root.get("Name"),
                                                         "%"+name+"%"
                               )
                       );
                   }

                   if(deptName!=null && !deptName.isEmpty()){
                       list.add(criteriaBuilder.like(root.get("department").get("deptName"),"%"+ deptName +"%"));
                   }
                   if(city!=null && !city.isEmpty()){
                       list.add(criteriaBuilder.like(root.get("address").get("city"),"%"+ city +"%"));
                   }
                   if(state!=null && !state.isEmpty()){
                       list.add(criteriaBuilder.like(root.get("address").get("state"),"%"+ state +"%"));
                   }


                   if(projectName!=null && !projectName.isEmpty()){

                       Join<Employee, Project> project =
                               root.join("projects");

                       list.add(criteriaBuilder.like(project.get("ProjectName"),"%"+projectName+"%"));
                   }

                   System.out.println("Predicates count = " + list.size());
                   return criteriaBuilder.and(list.toArray(new Predicate[0]));

               }
           };
    }
}
