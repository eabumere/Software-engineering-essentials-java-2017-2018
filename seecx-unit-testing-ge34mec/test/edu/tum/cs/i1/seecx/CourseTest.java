package edu.tum.cs.i1.seecx;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CourseTest {

	@Test
	public void testGetTitle() {
		String title = "SEECx";
		Course course = new Course(title);
		assertEquals("getTitle doesn't return the correct title", title, course.getTitle());
	}

	@Test
	public void testGetNumberOfAttendeesWithNoAttendees() {
		Course course = new Course("SEECx");
		assertTrue(course.getNumberOfAttendees() == 0);		
	}

	@Test
	public void testGetNumberOfAttendeesWithTwoAttendees() {
		Course course = new Course("SEECx");
		List<Student> attendees = new ArrayList<Student>();
		Student student1 = new Student("Feri", "Nagy", "1997", "Info", "Business");
		Student student2 = new Student("Pali", "Nagy", "1997", "Info", "Business");
		attendees.add(student1);
		attendees.add(student2);
		course.setAttendees(attendees);
		assertTrue(course.getNumberOfAttendees() == 2);		
	}
}