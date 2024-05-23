package Week2.OOPInheritence;

public class Bike extends Vehicle {


    private String handle;


    //overriding: allows a subclass to provide a specific implementation of a method that is already provided by it's parents class.
    //the subclass must have the same method name, same return type, and parameter list as the method in the parent class
    //when you override, only the executing block of code changes

    @Override
    public void driving(){

        System.out.println("The Bike is moving");
    }
    
}
