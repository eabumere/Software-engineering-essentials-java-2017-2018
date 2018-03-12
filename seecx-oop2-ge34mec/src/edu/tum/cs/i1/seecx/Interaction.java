package edu.tum.cs.i1.seecx;

public abstract class Interaction {

    public Person initiator;

    public Interaction(Person initiator) {
        this.initiator = initiator;
    }

    public abstract void printInteraction();

}
