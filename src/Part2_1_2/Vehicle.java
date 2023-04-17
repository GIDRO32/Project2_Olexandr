package Part2_1_2;

public class Vehicle {
    public void drive() {
        System.out.println("Driving...");
    }
}

class Car extends Vehicle {
    public void honk() {
        System.out.println("Honking...");
    }
}
class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car(); // creating an instance of subclass Car while declaring it as type of superclass Vehicle
        myCar.drive(); // calling the inherited method from Vehicle
        // myCar.honk(); // this would not work because the type is still Vehicle, not Car
        System.out.println(myCar.getClass()); // printing the class of the instance
    }
}