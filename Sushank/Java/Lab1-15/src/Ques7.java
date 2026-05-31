// Constructor of Super Class

class Parent {
    Parent() {
        System.out.println("Parent class constructor is called");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("Child class constructor is called");
    }
}

public class Ques7 {
    public static void main(String[] args) {
        // Child c = new Child();
    }
}
