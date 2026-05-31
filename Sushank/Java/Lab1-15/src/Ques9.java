// Dynamic Method Dispatch Example

class Food {
    void taste() {
        System.out.println("Food has different tastes");
    }
}

class Pizza extends Food {
    void taste() {
        System.out.println("Pizza tastes cheesy");
    }
}

class Mango extends Food {
    void taste() {
        System.out.println("Mango tastes sweet");
    }
}

public class Ques9 {
    public static void main(String[] args) {
        Food food;

        food = new Pizza();
        food.taste();

        food = new Mango();
        food.taste();
    }
}

// Why is it called Dynamic Method Dispatch?

// Because Java decides which method to run:

// at runtime
// based on actual object (Pizza, Mango)
// not based on reference type (Food)