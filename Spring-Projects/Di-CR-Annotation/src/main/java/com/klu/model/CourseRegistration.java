package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CourseRegistration {

    @Value("101")
    private int rollNo;

    @Value("Yash")
    private String studentName;

    @Value("FSAD")
    private String courseName;

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Student Name: " + studentName);
        System.out.println("Course Name: " + courseName);
    }
}
