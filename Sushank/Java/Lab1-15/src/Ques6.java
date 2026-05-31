// Multilevel Inheritance Example

class Person {
    void showName() {
        System.out.println("Name: Ram");
    }
}

class Teacher extends Person {
    void showJob() {
        System.out.println("Job: Teacher");
    }
}

class MathTeacher extends Teacher {
    void showSubject() {
        System.out.println("Subject: Mathematics");
    }
}

public class Ques6 {
    public static void main(String[] args) {
        MathTeacher teacher = new MathTeacher();

        teacher.showName();
        teacher.showJob();
        teacher.showSubject();
    }
}
