package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	static List<Student> studentList=new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("***********Student Management System******************");
		System.out.println("***********WelCome***************");
		
		List<Student> list=new ArrayList<Student>();
		
		Student s1;
		s1=new Student("Rutuja", 24, "S-1");
		s1.enrollCourse("Javascript");
		s1.enrollCourse("Javascript");
		s1.enrollCourse("Javascript");
		s1.enrollCourse("Javascript");
		s1.enrollCourse("Data Science");
		s1.enrollCourse("Java");
		list.add(s1);
		//System.out.println(s1); //when we print the object it will show us the to string method output
		
		
		Student s2=new Student("Vaibhav",28,"S-7");
		s2.enrollCourse("DSA");
		s2.enrollCourse("Python");
		s2.enrollCourse("Javascript");
		list.add(s2);
		
		Student s3=new Student("Vrushali",30,"S-9");
		s3.enrollCourse("DSA");
		s3.enrollCourse("Machine learning");
		list.add(s3);
		
		Student s4=new Student("Keshar",31,"S-11");
		s4.enrollCourse("DSA");
		s4.enrollCourse("Javascript");
		list.add(s4);
		
		s1.printStudentInfo();
		s2.printStudentInfo();
		s3.printStudentInfo();
		s4.printStudentInfo();
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
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
	



