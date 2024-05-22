package Week2.OOPEncapsulation;

public class Main {

    public static void main(String[] args){


        Dog d1 = new Dog();

        //we use our objects to invoke/call methods in a class
        d1.setName("Doug");
        d1.setBreed("Golden Retriever");
        d1.setGender("Male");
        d1.setAge(6);
        d1.setColor("Brown");


        System.out.println("Your dog's name is: " + d1.getName());

        d1.sleep();

        d1.bark();


        Dog d2 = new Dog("Buddy", "Jack Russell", 4, "male", "black");

        d2.bark();
        


    }
    
}
