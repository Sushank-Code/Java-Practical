
class Student {
    // Instance variables
    String name;
    String course;

    // Constructor
    Student(String n, String c) {
        name = n;
        course = c;
    }

    // Method
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

public class FirstDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Sushank Lamsal", "Bsc.CSIT");
        s1.display();
    }
}