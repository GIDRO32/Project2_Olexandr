package Part2_1_5;

public class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound(); // prints "The animal makes a sound"

        Cat cat = new Cat();
        cat.makeSound(); // prints "The cat meows"

        Animal animalCat = new Cat();
        animalCat.makeSound(); // prints "The cat meows"
    }
}
