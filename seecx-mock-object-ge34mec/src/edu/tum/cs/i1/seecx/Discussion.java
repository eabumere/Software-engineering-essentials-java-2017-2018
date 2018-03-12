package edu.tum.cs.i1.seecx;



import java.util.ArrayList;
import java.util.List;

public class Discussion {

    private String topic;
    private Course course;
    private List<Comment> comments = new ArrayList<Comment>();


    public Discussion() {
    }

    public Boolean startCourseDiscussion(Course course, Person person, String topic) {

        if(!course.isDiscussionAllowed(person)) {
            return false;
        }

        this.course = course;
        this.topic = topic;

        return true;
    }

    public Boolean addComment(Comment comment)  {
        if(comment.save()) {
            comments.add(comment);
            return true;
        } else {
            return false;
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getNumberOfComments() {
        return comments.size();
    }
}
