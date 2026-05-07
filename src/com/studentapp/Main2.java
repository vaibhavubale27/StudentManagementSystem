package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	
	static List<Student> studentList=new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("***********Student Management System******************");
		System.out.println("***********WelCome***************");
		
		List<Student> list=new ArrayList<Student>();
		//Here we are adding scanner logic
		Scanner scanner=new Scanner(System.in);
		String name=scanner.next();
		System.out.println("You have entered the name "+name);
		int age=scanner.nextInt();
		System.out.println("You have entered the age "+age);
	
		
		Student result=checkStudetIdIsPresentOrNot("S-9");
		System.out.println("result -"+result);
		
		sortByName();
		
}

	public static Student checkStudetIdIsPresentOrNot(String studentId) {
		Student result=null;
		try {
		result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
				.orElseThrow(() -> new RuntimeException("No data found!!"));
		}catch(RuntimeException e) {
			System.err.println("No data found for given student Id-"+ studentId);
			System.out.println(e);
		}
		return result;
	}
	
	private static void sortByName() {
		//This is the regular approach for creating an comparator
		/*Comparator<Student> studentComparator =new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
			
		};*/
		
		Comparator<Student> studentComparator =(o1,o2) -> o1.getName().compareTo(o2.getName());
		
		 Collections.sort(studentList, studentComparator);
		 System.out.println(studentList);
		
	}
	

		
	}
	



