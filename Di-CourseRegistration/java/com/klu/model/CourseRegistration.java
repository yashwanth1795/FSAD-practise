package com.klu.model;

public class CourseRegistration {
	
	private int rollno;
	private String studentName;
	private int semester;
	private String Course;
	public  CourseRegistration(int rollno,String studentName) {
		this.rollno=rollno;
		this.studentName=studentName;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public void setCourse(String course) {
		Course = course;
	}
	public void display() {
		System.out.println("Rollno:"+rollno);
		System.out.println("Student Name:"+studentName);
		System.out.println("Course:"+Course);
		System.out.println("Semester:"+semester);
	}

	}


