// Interface Extending 

interface BasicPhone {
    void call();
}

interface SmartPhone extends BasicPhone {    // extends ( inherited )
    void internet();
}

class MyPhone implements SmartPhone {       // implements
    public void call() {
        System.out.println("Calling a friend");
    }

    public void internet() {
        System.out.println("Using internet on phone");
    }
}

public class Ques11 {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone();

        phone.call();
        phone.internet();
    }
}
