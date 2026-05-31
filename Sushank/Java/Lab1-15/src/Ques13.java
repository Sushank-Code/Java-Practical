// Inter Thread Communication 

class MessageBox {
    String message;
    boolean hasMessage = false;

    synchronized void writeMessage(String text) {
        message = text;
        hasMessage = true;
        System.out.println("Writer wrote a message");
        notify();
    }

    synchronized void readMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Reader interrupted");
            }
        }

        System.out.println("Reader received: " + message);
    }
}

class Writer extends Thread {
    MessageBox box;

    Writer(MessageBox box) {
        this.box = box;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Writer interrupted");
        }

        box.writeMessage("Hello from writer thread");
    }
}

class Reader extends Thread {
    MessageBox box;

    Reader(MessageBox box) {
        this.box = box;
    }

    public void run() {
        box.readMessage();
    }
}

public class Ques13 {
    public static void main(String[] args) {
        MessageBox box = new MessageBox();

        Reader reader = new Reader(box);
        Writer writer = new Writer(box);

        reader.start();
        writer.start();
    }
}
