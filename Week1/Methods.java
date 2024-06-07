package Week1;

import java.util.Scanner;

//methods and functions are synonymous terms
public class Methods {


    public static void main(String[] args){

        //an instance of a class is called an object
        //The scanner is able to read user input, and it can read files
        Scanner input  = new Scanner(System.in);

        System.out.println("Enter the first number: ");

        int a = input.nextInt();

        System.out.println("Enter the second number: ");

        int b = input.nextInt();

        int result = addNumbers(a, b);

        System.out.println("The sum is: " + result);

        

    }

    //method is a reusable piece of code, methods are actions or behaviors
    //access modifier, return type, method name(parameters) { body of code }
    //static methods belong to the class they were declared in
    public static int addNumbers(int firstNumber, int secondNumber){

        //local variable
        int sum;

        sum = firstNumber + secondNumber;

        return sum;

    }

    
}
