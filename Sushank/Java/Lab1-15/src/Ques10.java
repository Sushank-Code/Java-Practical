// Multiple Inheritance Using Interface

interface Printable {
    void print();
}

interface Showable {
    void show();
}

class StudentRecord implements Printable, Showable {   // interface = implements
    public void print() {
        System.out.println("Printing student record");
    }

    public void show() {
        System.out.println("Showing student name: Harry");
    }
}

public class Ques10 {
    public static void main(String[] args) {
        StudentRecord student = new StudentRecord();

        student.print();
        student.show();
    }
}
