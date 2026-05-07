package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}
	}

	public void enrollCourse(String course) {
		if(ValidateCourseName(course)) {
		if(!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student is enrolled for the " + course + " course succesfully");
		}else {
			System.err.println("Student is already enrolled for this Course " + course);
		}
		}
		
	}

	public void printStudentInfo() {
		System.out.println("=================Student Information=================");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student studentId: " + studentId);
		System.out.println("Student courses: " + courses);
		System.out.println("=====================================================");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// Validation Method

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid student age, It should be in between 19 to 35");
			return false;
		}

	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		boolean result = Pattern.matches(nameRegex, name);
		if (result) {
			return true;
		} else {
			System.err.println("Entered name is invalid, Please enter valid name containing alphabets only");
			return false;
		}

	}

	private boolean validateStudentId(String studentId) {
		String studentRegex="S-[0-9]+$";//Also we can use this one too "S-\\d+$" //S-123
		boolean result = Pattern.matches(studentRegex, studentId);
		if (result) {
			return true;
		} else {
			System.err.println("Entered Student Id is invalid, Please enter valid Student Id start with S-");
			return false;
		}
	}
	
	public boolean ValidateCourseName(String Course) {
		if(Course.equalsIgnoreCase("Java") || Course.equalsIgnoreCase("Javascript") || Course.equalsIgnoreCase("DSA") || Course.equalsIgnoreCase("Devops")) {
			return true;
		}
		else {
			System.err.println("Entered course "+Course+" is invalid, Please enter valid course [Java,Javascript,DSA,Devops] from list");
			return false;
		}
		
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
