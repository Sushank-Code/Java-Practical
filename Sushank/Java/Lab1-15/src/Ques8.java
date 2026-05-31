// Method Overriding Example

class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Bike extends Vehicle {

    // @Override is optional.
    // It helps detect mistakes.
    
    @Override
    void start() {
        System.out.println("Bike starts");
    }
}

public class Ques8 {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.start();
    }
}
