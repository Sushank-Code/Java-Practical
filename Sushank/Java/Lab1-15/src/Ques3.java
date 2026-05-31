
// Method Overloading
public class Ques3 {
    static void add(int x, int y) {
        System.out.println("Sum of 2 integers: " + (x + y));
    }

    static void add(String x, String y) {
        System.out.println("Sum of 2 strings: " + (x + y));
    }

    public static void main(String[] args) {
        add(10, 20);
        add("Hello, ", "World!");
    }
}
