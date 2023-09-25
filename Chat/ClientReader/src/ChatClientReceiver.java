import java.io.*;
import java.net.*;

public class ChatClientReceiver {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 3000;

        try (Socket socket = new Socket(serverAddress, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String serverResponse = input.readLine();
            System.out.println("Message received from client " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}