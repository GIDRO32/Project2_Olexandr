package Part2_1_7;

public class Animal {
    private String name;

    public Animal() {
        System.out.println("An animal has been created");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("An animal named " + name + " has been created");
    }
}

class Cat extends Animal {
    public Cat() {
        super(); // calls the default constructor of the Animal class
        System.out.println("A cat has been created");
    }

    public Cat(String name) {
        super(name); // calls the non-default constructor of the Animal class with name parameter
        System.out.println("A cat named " + name + " has joined the game");
    }
}

class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(); // prints "An animal has been created" followed by "A cat has been created"
        Cat cat2 = new Cat("Fluffy"); // prints "An animal named Fluffy has been created" followed by "A cat named Fluffy has been created"
        Cat cat3 = new Cat("KillerTiger228");
    }
}
