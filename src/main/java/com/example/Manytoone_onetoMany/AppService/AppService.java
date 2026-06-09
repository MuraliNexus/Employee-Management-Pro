package com.example.Manytoone_onetoMany.AppService;


import com.example.Manytoone_onetoMany.Entity.Address;
import com.example.Manytoone_onetoMany.Entity.Department;
import com.example.Manytoone_onetoMany.Entity.Employee;
import com.example.Manytoone_onetoMany.Entity.Project;
import com.example.Manytoone_onetoMany.Repoistory.AddressRepoistory;
import com.example.Manytoone_onetoMany.Repoistory.DepartmentRepoistory;
import com.example.Manytoone_onetoMany.Repoistory.EmployeeRepoistory;
import com.example.Manytoone_onetoMany.Repoistory.ProjectRepoistory;
import com.example.Manytoone_onetoMany.Specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private DepartmentRepoistory departmentRepoistory;

    @Autowired
    private EmployeeRepoistory employeeRepoistory;

    @Autowired
    private AddressRepoistory addressRepoistory;

    @Autowired
    private ProjectRepoistory projectRepoistory;

    /// saving departments
    public Department SaveDepartment(Department department) {
        return departmentRepoistory.save(department);
    }


    /// saving employee;
    public Employee SaveEmployee(String empName, Long deptId, List<Long> projectId, String city, String state) {

         Department dept = departmentRepoistory.findById(deptId).orElseThrow();
         Address address = new Address(city,state);
         List<Project> projects = projectRepoistory.findAllById(projectId);
         Employee employee = new Employee(empName,dept,address,projects);

         return employeeRepoistory.save(employee);
    }


    public List<Department> ShowALLDepartments() {
        return departmentRepoistory.findAll();
    }

    public List<Employee> ShowAllEmployees() {
        return employeeRepoistory.findAll();
    }


    public List<Address> ShowAllAddress() {
        return addressRepoistory.findAll();
    }

    public Project PostProject(Project projects) {
        return projectRepoistory.save(projects);
    }



    public List<Employee> findAllEmployeeByFilter(Pageable pageable,Long id,String name,String departName,String city,String state,String projectName) {
       Specification<Employee> specfic = EmployeeSpecification.getSpecifications(id,name,departName,city,state,projectName);
       return employeeRepoistory.findAll(specfic,pageable).getContent();
    }


    public Employee UpdateEmployee(Long id, Employee employee) {
        Employee existsingEmployee = employeeRepoistory.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        existsingEmployee.setName(employee.getName());
        existsingEmployee.setDepartment(employee.getDepartment());
        existsingEmployee.setProjects(employee.getProjects());
        existsingEmployee.setAddress(employee.getAddress());

        return employeeRepoistory.save(existsingEmployee);
    }

    public void DeleteEmployeeByid(Long id) {
         employeeRepoistory.deleteById(id);
    }


    public Department UpdateDepartment(Long id, Department department) {
        Department updateableDept = departmentRepoistory.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found"));

        updateableDept.setDeptName(department.getDeptName());
       return departmentRepoistory.save(updateableDept);
    }

    public void DeleteDepartment(Long id) {
      departmentRepoistory.deleteById(id);
    }

    public Project UpdateProject(Long id, Project project) {
        Project updateProject = projectRepoistory.findById(id)
                .orElseThrow(()->new RuntimeException("project not found"));
        updateProject.setProjectName(project.getProjectName());
        return projectRepoistory.save(updateProject);
    }

    public void DeleteProject(Long id) {
        projectRepoistory.deleteById(id);
    }
}
