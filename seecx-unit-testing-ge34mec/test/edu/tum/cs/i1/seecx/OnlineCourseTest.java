package edu.tum.cs.i1.seecx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;


public class OnlineCourseTest {

	@Test 
	public void  testSetUrlWithValidUrl() {
		String urlString = "https://courses.edx.org/courses/course-v1:TUMx+SEECx+3T_2017/course/";
		OnlineCourse onlineCourse = new OnlineCourse("SEECx");
		try {
			onlineCourse.setUrl(urlString);
			URL url = new URL(urlString);
			assertEquals("URL doesn't match", url, onlineCourse.getUrl());
		} catch (MalformedURLException e) {
			fail("Invalid URL");
		}
	}
	
	@Test(expected = MalformedURLException.class)
	public void testSetUrlWithInvalidUrl() throws MalformedURLException {
		String urlString = "invalid-url";
		OnlineCourse onlineCourse = new OnlineCourse("SEECx");
		onlineCourse.setUrl(urlString);
	}

}
