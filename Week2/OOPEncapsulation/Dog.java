package Week2.OOPEncapsulation;


//encapsulation: wrapping up of data under a single unit
public class Dog {

    //instance variables, properties, fields
    //the private access modifier means a variable is only accessible within the class
    private String name;

    private String breed;

    private int age;

    private String gender;

    private String color;

    private String allergies;



        //constructor - allows you create an object
        //allows you to set the initial state of an object
        //empty constructor
        public Dog(){

        }

        //how you make your constructor depends on what resources are needed for the method that the object will be calling
        public Dog(String name, String breed, int age, String gender, String color){

            //when you see the this operator before a variable, it is referring to the instance variable
            this.name = name;
            this.breed = breed;
            this.age = age;
            this.gender = gender;
            this.color = color;

        }

        public Dog(String name){
            this.name = name;
        }

    //getter and setter methods
    //getter: is a public method that allows you to retrieve/access the state of a variable
    //setter: is a public method that allows you to modify the state of a variable

    public String getName(){
        return name;

    }

    public void setName(String name){
        this.name = name;

    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
        this.age = age;
        }
        else{
            System.out.println("Invalid age entered. Try again!");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }



    //methods - actions/behaviors of a dog
    public void sleep(){
        System.out.println("I'm sleeping");
    }

    public void bark(){
        System.out.println(name + " said, Woof woof!");
    }

    
}
