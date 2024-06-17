package Week2;

public class StringMethods {

    public static void main(String[] args){


        String name = "Hello, This is Nkazimulo";

        // char[] name1 = {'N', 'k', 'a', 'z', 'i', 'm', 'u', 'l', 'o'};

        for(int i = 0; i < name.length(); i++){

            System.out.println(name.charAt(i));
        }
 
        //returns the size of a string
        System.out.println(name.length());

        //return a new string within the range of the beginning index and ending index
        System.out.println("Your nickname is: " + name.substring(0,9));

        //return the index of the beginning of a string 
        //if you get -1 it doesn't find an index
        System.out.println(name.indexOf("this"));

        //allows you to change the case of a string
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());


        String userInput = "potato,tomato,spinach;celery";

        //the split method separates values in a string based on the delimiter(what is inside the parantheses)

        String[] veggies = userInput.split(",");

        //allows you to have multiple delimiters
        // String[] veggies = userInput.split("[,;//s]+");

        for(String veg: veggies){

            System.out.println(veg);
        }

    }
    
}
