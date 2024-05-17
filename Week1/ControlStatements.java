package Week1;

import java.util.Scanner;

public class ControlStatements {


    public static void main(String[] args){

        //declare an instance of the Scanner class that can read input from the standard input stream
        Scanner input = new Scanner(System.in);

        //prompt the user to enter a grade
        System.out.println("Enter a grade: ");

        //we use our Scanner object(input) to call nextInt() which can read integer values from the input stream

        int grade = input.nextInt();

        //we call our method and pass the entered value for evaluation
        checkGrade(grade);
       


    }


    public static void checkGrade(int grade){

        //decision making statement
        //if(condition){body of code that will run if the condition is satisfied}

        //nested if statement
        //the second(inner) if statement will only run if the first(outer) statement is true/satisfied
        if(grade > 0){
            if(grade >= 70){
                System.out.println("You're in the top 1%");
            }else if(grade >= 60){
                System.out.println("You're in the top 5%");
            }
            else{
                System.out.println("You're not in the top 1%");
            }
        }
        
       







    }
    


    
}
