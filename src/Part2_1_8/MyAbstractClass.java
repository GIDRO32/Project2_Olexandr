package Part2_1_8;

abstract class MyAbstractClass {
    public abstract void myAbstractMethod();
}

class SuperClass extends MyAbstractClass {
    @Override
    public void myAbstractMethod() {
        System.out.println("This is an implementation of my abstract method");
    }
}

class Main {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        superClass.myAbstractMethod(); // prints "This is an implementation of my abstract method"
    }
}
