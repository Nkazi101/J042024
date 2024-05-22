package Week2.OOPInheritence;


//the keyword for inheriting from a parent class is "extends"
//the key for implementing an interface is "implements"
//java doesn't support for multiple inheritence
//a class can implement any number of interfaces, but can extend only one class
public class Car extends Vehicle implements VehicleBehaviors {

    private String steering;

    private String musicSystem;

    private String seatbelt;

    private String airconditioner;


    public void driving(){

        System.out.println("The car is driving" + cardriving);
    }

    public String stop(){

        return "skrrrrrrrrrr";
    }




    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public String getMusicSystem() {
        return musicSystem;
    }

    public void setMusicSystem(String musicSystem) {
        this.musicSystem = musicSystem;
    }

    public String getSeatbelt() {
        return seatbelt;
    }

    public void setSeatbelt(String seatbelt) {
        this.seatbelt = seatbelt;
    }

    public String getAirconditioner() {
        return airconditioner;
    }

    public void setAirconditioner(String airconditioner) {
        this.airconditioner = airconditioner;
    }

    

    
}
