package edu.tum.cs.i1.seecx;

public class Comment extends Interaction implements Likeable{

    public String text;

    public Comment(Person initiator, String text) {
        super(initiator);
        this.text = text;
    }

    @Override
    public void printInteraction() {
    	System.out.println(this.text + this.initiator.firstName);
    }

	@Override
	public void like() {
		System.out.println("Like");		
	}
    
}
