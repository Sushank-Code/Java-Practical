
// Single and Multilevel Inheritance

//single
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

// Multilevel
class GrandFather {
    void house() {
        System.out.println("GrandFather has a house");
    }
}

class Father extends GrandFather {
    void bike() {
        System.out.println("Father has a bike");
    }
}

class Child extends Father {
    void mobile() {
        System.out.println("Child has a mobile");
    }
}

public class Ques4 {
    public static void main(String[] args) {

        // single level inheritace
        Dog dog = new Dog();
        dog.sound(); 
        dog.bark();  

        // Multilevel inheritance
        Child c = new Child();
        c.house();
        c.bike();
        c.mobile();
    }
}
