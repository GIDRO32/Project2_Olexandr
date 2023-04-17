package Part2_1_3;

public class Vehicle {
    private int maxSpeed; // private instance variable
    protected int numWheels; // protected instance variable
    public String brand; // public instance variable

    public Vehicle(int maxSpeed, int numWheels, String brand) {
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    protected void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
class Car extends Vehicle {
    public Car(int maxSpeed, int numWheels, String brand) {
        super(maxSpeed, numWheels, brand);
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public void setMaxSpeed(int maxSpeed) {
        super.setMaxSpeed(maxSpeed); // accessing the superclass method
    }

    public void printBrand() {
        System.out.println("Brand: " + brand); // accessing the public superclass instance variable
    }
}
