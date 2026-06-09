package com.example.Manytoone_onetoMany.Controller;


import com.example.Manytoone_onetoMany.AppService.AppService;
import com.example.Manytoone_onetoMany.Entity.Address;
import com.example.Manytoone_onetoMany.Entity.Department;
import com.example.Manytoone_onetoMany.Entity.Employee;
import com.example.Manytoone_onetoMany.Entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/App")
public class AppController {

     @Autowired
     private AppService appService;

    @PostMapping("/department")
    public Department saveDepartment(
            @RequestBody Department department
    ){
        Department departments = appService.SaveDepartment(department);
        return departments;
    }


    @PostMapping("/employee")
    public Employee SaveEmployee(
            @RequestParam ("Empname") String empName,
            @RequestParam ("id") Long deptId,
            @RequestParam("pro_id") List<Long> projectId,
            @RequestParam ("city") String city,
            @RequestParam("state") String state
    ){
        return appService.SaveEmployee(empName,deptId,projectId,city,state);
    }

    @GetMapping("/departments")
    public List<Department> AllDepartments(){
        return appService.ShowALLDepartments();
    }

    @GetMapping("/employees")
    public List<Employee> AllEmployees(){
        return appService.ShowAllEmployees();
    }

    @GetMapping("/address")
    public List<Address> AllAddress(){
        return appService.ShowAllAddress();
    }

    @PostMapping(value = "/projects",consumes = "application/json")
    public Project PostProjects(@RequestBody Project projects){
        return appService.PostProject(projects);
    }


    @PutMapping("/employee/{id}")
    public Employee UpdateEmployee(@PathVariable("id")Long Id,@RequestBody Employee employee){
        return appService.UpdateEmployee(Id,employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id")Long id){
         appService.DeleteEmployeeByid(id);
         return "Deleted Successfully";
    }

    @PutMapping("/department/{id}")
    public Department UpdateDepartment(@PathVariable("id")Long id ,@RequestBody Department department){
        return appService.UpdateDepartment(id,department);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable("id")Long id){
         appService.DeleteDepartment(id);
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable("id")Long id,@RequestBody Project project){
        return appService.UpdateProject(id,project);
    }

    @DeleteMapping("projects/{id}")
    public void DeleteProject(@PathVariable("id")Long id){
         appService.DeleteProject(id);
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        appService.getAllProjects();
    }




    @GetMapping("/filter")
    public List<Employee> FindAllEmployeeByfilter(
                  @RequestParam(required = false,defaultValue = "5") int pageSize,
                  @RequestParam(required = false,defaultValue = "1") int pageNo,
                  @RequestParam(required = false) Long id,
                  @RequestParam(required = false) String name,
                  @RequestParam(required = false) String departName,
                  @RequestParam(required = false) String city,
                  @RequestParam(required = false) String state,
                  @RequestParam(required = false) String projectName,
                  @RequestParam(required = false,defaultValue = "id")  String sortBy,
                  @RequestParam(required = false,defaultValue = "ASC") String sortDir
    )
    {
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("ASC")){
            sort = Sort.by(sortBy).ascending();
        }
        else{
            sort = Sort.by(sortBy).descending();
        }

        return appService.findAllEmployeeByFilter(PageRequest.of(pageNo-1,pageSize,sort),id,name,departName,city,state,projectName);

    }

}
