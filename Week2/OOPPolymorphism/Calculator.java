package Week2.OOPPolymorphism;


public class Calculator {


    int a;

    int b;


     //overloading: allows a class to have multiple methods with the same name but different parameters
    //the compiler determines which method to call at compile time based on the number and types of arguments passed to the method 

    public int calculate(int a, int b){

        return a + b;
    }
    

    public double calculate(double a, double b){

        return a * b;
    }





    
}
