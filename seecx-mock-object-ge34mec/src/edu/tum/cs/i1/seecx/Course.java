package edu.tum.cs.i1.seecx;

import java.util.List;
import java.util.Date;

public interface Course {
    public String getTitle();
    public void setTitle(String title);
    public Lecturer getLecturer();
    public void setLecturer(Lecturer lecturer);
    public List<Date> getDates();
    public void setDates(List<Date> dates);
    public List<Student> getAttendees();
    public void setAttendees(List<Student> attendees);
    public Integer getNumberOfAttendees();
    public Boolean isDiscussionAllowed(Person person);
}