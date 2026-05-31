import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Use: java TCP server");
            System.out.println("Or : java TCP client");
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
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("TCP Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println("Client says: " + message);

            output.println("Hello client, message received.");

            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    static void startClient() {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter message for server: ");
            String message = keyboard.readLine();

            output.println(message);

            String reply = input.readLine();
            System.out.println("Server says: " + reply);

            socket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
