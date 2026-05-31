// Multithreading Using Thread Class and Runnable Interface

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread class: " + i);
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Runnable interface: " + i);
        }
    }
}

public class Ques12 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());  // runnable inside Thread instead of making new obj

        t1.start();
        t2.start();
    }
}
