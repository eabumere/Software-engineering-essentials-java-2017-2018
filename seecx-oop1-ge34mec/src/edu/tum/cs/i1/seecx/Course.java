package edu.tum.cs.i1.seecx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Implement Course Class

public class Course {
	public String title;
	public Lecturer lecturer;
	public List<Date> dates;
	public List<Student> attendees;
	
	public Course(String title) {
		super();
		this.title = title;
		dates = new ArrayList<Date>();
		attendees = new ArrayList<Student>();
	}
	
	public void printCourseTitle() {
		System.out.println(this.title);
	}
	
}