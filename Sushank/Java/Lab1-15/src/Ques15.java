import java.io.*;

// Serialization and Deserialization 
class Student implements Serializable {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;           
        this.name = name;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}

public class Ques15 {
    public static void main(String[] args) {
        Student student = new Student(1, "Ram");

        try {
            // serialization
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Output/student.ser"));
            out.writeObject(student);
            out.close();

            // deserialization
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Output/student.ser"));
            Student savedStudent = (Student) in.readObject();
            in.close();

            System.out.println("Student data after deserialization:");
            savedStudent.display();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
}
