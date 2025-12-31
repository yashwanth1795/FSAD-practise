package com.klu.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptid;

    private String deptname;

    // One Department has many Employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // Default constructor (mandatory)
    public Department() {
    }

    // Getters and Setters
    public int getDeptId() {
        return deptid;
    }

    public void setDeptId(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptName() {
        return deptname;
    }

    public void setDeptName(String deptname) {
        this.deptname = deptname;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
