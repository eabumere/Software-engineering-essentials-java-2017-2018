# Object Oriented Programming 2 Exercise

Welcome to the 2nd programming exercise! In this exercise, you will implement some more parts of the University Application with respect to FR4.

> FR4: Add comments: A student can add **comments** about a course and thus
> start a discussion. Others can **like** the comment and write follow-up
> comments.

 
Therefore the following model is given and already implemented:

@startuml

class Interaction {
  +initiator: Person
  +printInteraction(): void
}


class Comment {
    +text: String
}
Comment -up-|> Interaction 

class Like {
}
Like -up-|> Interaction 




@enduml


### Part 1: Polymorphism

Currently, the **`printInteraction()`** method prints out the first name of
the `initiator` only. We want to override this method in the subclasses to
print out more information.

**You have the following tasks:**

1.  ✅[printInteraction() in Like](testPrintInteractionForLike)
Override `printInteraction()` in `Like` so that it prints out "Like
    by" and the `firstName` of `initiator`.
2.  ✅[printInteraction() in Comment](testPrintInteractionForComment)
Override `printInteraction()` in `Comment` so that it prints out
    the `text` of the comment and the `firstName` of `initiator`.

 

### Part 2: Abstraction

It came clear that we do not need any instances of the `Interaction` class
itself. We want all `Interaction` objects to be either a `Like` or
`Comment` object. 

**Therefore, you have the following tasks:**

1. ✅[abstract Interaction  class](testMethods[Checking class Interaction])
Make the Interaction class an **`abstract`** class.
2. ✅[abstract printInteraction](testMethods[Checking class Interaction])
Make the method `printInteraction()` of the class `Interaction` abstract.

**Rationale:** We want to make sure that all subclasses of Course do implement the `printInteraction()` method. Please note that abstract methods are not allowed to have any implementation.



 

### Part 3: Interfaces

We want to offer students the possibility to like comments and other
objects (such as courses). For reusability we, want to create an
**Interface** for all objects, which can be liked.

**You have the following tasks:**

1.  ✅[Likeable Interface](testConstructors[Checking class Likeable])
Create an Interface named **`Likeable`**.
2.  ✅[like Method](testMethods[Checking class Likeable])
Decalore one method `public void like();` in this interface
3.  ✅[Comment is Likeable](testMethods[Checking class Comment])
Let the `Comment` class implement the `Likeable` interface. (Provide a print statement to the console in the new `like()` method in `Comment`)
