package Part2_1_1;

// Part 2.1.1 creating Superclass
public class Vehicle {
    private int numWheels;
    private String brand;

    public Vehicle(int numWheels, String brand) {
        this.numWheels = numWheels;
        this.brand = brand;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public String getBrand() {
        return brand;
    }
}

// Part 2.1.1 creating Subclass
class Car extends Vehicle {
    private int numDoors;

    public Car(int numWheels, String brand, int numDoors) {
        super(numWheels, brand);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }
}

// Create an instance of the subclass
class Main {
    public static void main(String[] args) {
        Car myCar = new Car(4, "Toyota", 4);
        System.out.println("My car has " + myCar.getNumWheels() + " wheels and " + myCar.getNumDoors() + " doors.");
    }
}
