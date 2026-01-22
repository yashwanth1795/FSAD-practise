package com.klu;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Required by Hibernate
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    // Optional but recommended
    // getters and setters
}
