package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Student> studentList = new ArrayList<>();
	private static Scanner scan;

	public static void main(String[] args) {
		System.out.println("***********Student Management System******************");

		List<Student> list = new ArrayList<Student>();
		scan = new Scanner(System.in);
		while (true) {
			System.out.println("***********WelCome***************");
			System.out.println("Select an option....");
			System.out.println("1. Register a student");
			System.out.println("2. Find student with student Id");
			System.out.println("3. List all student information");
			System.out.println("4. List all student information in sorted order");
			System.out.println("5. Exit");

			int option = scan.nextInt();

			if (String.valueOf(option).equalsIgnoreCase("Done")) {
				break;
			}

			switch (option) {
			case 1:
				enrollStudent(scan);
				break;
			case 2:
				findStudentByStudentId(scan);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid option selected!...Enter in between 1 to 5");
				break;

			}
		}

	}

	public static Student checkStudetIdIsPresentOrNot(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.err.println("No data found for given student Id-" + studentId);
			System.out.println(e);
		}
		return result;
	}

	private static void sortByName() {
		// This is the regular approach for creating an comparator
		/*
		 * Comparator<Student> studentComparator =new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName());
		 * 
		 * }
		 * 
		 * };
		 */

		Comparator<Student> studentComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(studentList, studentComparator);
		printAllStudentData();

	}

	private static void enrollStudent(Scanner scanner) {
		System.out.println("Enter the student name");
		String name = scanner.next();
		System.out.println("Enter the student age");
		int age = scanner.nextInt();
		System.out.println("Enter the student Id value");
		String studentId = scanner.next();
		Student newStudent = new Student(name, age, studentId);
		studentList.add(newStudent);
		while (true) {
			System.out.println("Enter the course to be enrolled!!");
			String courseName = scanner.next();
			if (courseName.equalsIgnoreCase("Done")) {
				break;
			}
			newStudent.enrollCourse(courseName);
		}

		newStudent.printStudentInfo();

	}

	private static void findStudentByStudentId(Scanner scanner) {
		Student studentFound = null;
		System.out.println("Enter Student Id Which You Wanted TO Fetch");
		String studentId=scanner.next();
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.err.println("No data found for given student Id-" + studentId);
			System.out.println(e);
		}
		studentFound.printStudentInfo();

	}

	private static void printAllStudentData() {
		if (studentList.size() > 0) {
			System.out.println(
					"===============================Print All Student Information============================");
			for (Student student : studentList) {
				student.printStudentInfo();

			}
		} else {
			System.err.println("Student list is empty,No stdent record found");
		}
    }

	private static void exit() {
		System.out.println("Good Bye");
		System.exit(0);

	}

}
