package edu.tum.cs.i1.seecx;

public class Like extends Interaction {

    public Like(Person initiator) {
        super(initiator);
    }
    
    @Override
    public void printInteraction() {
    	System.out.println("Like by " + this.initiator.firstName);
    }
}
