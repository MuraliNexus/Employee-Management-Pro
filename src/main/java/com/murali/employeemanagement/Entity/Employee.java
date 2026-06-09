package com.murali.employeemanagement.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    /// MANY employees to one department

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")
    @JsonProperty("name")
    private String Name;

    /// MANY TO One --DEPARTMENTS
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    /// ONE TO ONE  --ADDRESS
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

/// MANY TO MANY
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST
    )
    @JoinTable(name = "Employee_Project_id",
           joinColumns = {
                  @JoinColumn(name = "employee_id",referencedColumnName = "id")
           },
       inverseJoinColumns = {
            @JoinColumn(name = "project_id",referencedColumnName = "id")/// referenceColumnName used most when the id is custome like ColumnNAME="emp_id"ie custom for database bcz hibernate can't identify
       }
    )
    private List<Project> projects;


    public Employee(String name,Department department,Address address,List<Project> projects) {
        Name = name;
        this.department = department;
        this.projects = projects;
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
