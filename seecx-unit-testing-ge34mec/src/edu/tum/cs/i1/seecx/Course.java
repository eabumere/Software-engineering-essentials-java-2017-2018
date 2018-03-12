package edu.tum.cs.i1.seecx;

import java.util.List;
import java.util.Date;

public class Course {

    public String title;
    public Lecturer lecturer;
    public List<Date> dates;
    public List<Student> attendees;

    public Course(String title) {
        this.title = title;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public List<Student> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Student> attendees) {
        this.attendees = attendees;
    }

    public Integer getNumberOfAttendees() {
        return attendees != null ? attendees.size() : 0;
    }

}
