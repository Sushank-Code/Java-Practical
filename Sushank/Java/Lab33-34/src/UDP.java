import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Use: java UDP server");
            System.out.println("Or : java UDP client");
            return;
        }

        if (args[0].equalsIgnoreCase("server")) {
            startServer();
        } else if (args[0].equalsIgnoreCase("client")) {
            startClient();
        } else {
            System.out.println("Invalid option. Use server or client.");
        }
    }

    static void startServer() {
        try {
            DatagramSocket socket = new DatagramSocket(6000);
            byte[] receiveData = new byte[1024];

            System.out.println("UDP Server started. Waiting for message...");

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client says: " + message);

            String reply = "Hello client, message received.";
            byte[] sendData = reply.getBytes();

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);

            socket.close();
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    static void startClient() {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter message for server: ");
            String message = scanner.nextLine();

            byte[] sendData = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 6000);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server says: " + reply);

            scanner.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
