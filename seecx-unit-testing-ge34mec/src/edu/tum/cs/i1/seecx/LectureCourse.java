package edu.tum.cs.i1.seecx;

import java.awt.Point;

public class LectureCourse extends Course {

    public Point location;

    public LectureCourse(String title, Point location) {
        super(title);
        this.location = location;
    }
    
}
