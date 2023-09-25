import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) {
        int port = 3000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("The chat server is on and waiting for a connection...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = input.readLine();
                System.out.println("Message received from client " + clientMessage);

                // Sending a message to the next client
                Socket nextClientSocket = serverSocket.accept();
                PrintWriter nextClientOutput = new PrintWriter(nextClientSocket.getOutputStream(), true);

                nextClientOutput.println(clientMessage);
                nextClientSocket.close();

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}