package edu.tum.cs.i1.seecx;

public interface Comment {

    public Boolean save();
    public String getText();
    public void setText(String text);
    public Person getAuthor();
    public void setAuthor(Person author);

}