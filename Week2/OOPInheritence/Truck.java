package Week2.OOPInheritence;

public class Truck extends Vehicle {
    

    private String steering;

    private String musicSystem;

    private String seatbelt;


    public void driving(){

        System.out.println("The truck is driving");
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


    

}
