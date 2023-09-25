import java.io.*;
import java.net.*;

public class ChatClientSender {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 3000;

        try (Socket socket = new Socket(serverAddress, port)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter your name: ");
            String name = consoleInput.readLine();

            System.out.println("Enter your message: ");
            String message = consoleInput.readLine();

            output.println(name + ": " + message);
            System.out.println("Message sent.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
