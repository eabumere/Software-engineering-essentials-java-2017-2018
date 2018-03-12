package edu.tum.cs.i1.seecx;

import java.net.URL;

// TODO: Implement OnlineCourse Class

public class OnlineCourse extends Course{
	public URL url;

	public OnlineCourse(String title, URL url) {
		super(title);
		this.url = url;
	}
	
	
	
}