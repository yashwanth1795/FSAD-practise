package com.klu.model;

import javax.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    private String empname;
    private double empsalary;

    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department department;

    // ✅ Default constructor (mandatory for Hibernate)
    public Employee() {
    }

    // ✅ Getters and Setters
    public int getEmpId() {
        return empid;
    }

    public void setEmpId(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empname;
    }

    public void setEmpName(String empname) {
        this.empname = empname;
    }

    public double getEmpSalary() {
        return empsalary;
    }

    public void setEmpSalary(double empsalary) {
        this.empsalary = empsalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
