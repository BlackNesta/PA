package ClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try {
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader requestReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter your request: ");
                String request = requestReader.readLine();
                out.println(request);
                String response = in.readLine();
                System.out.println(response);
            }
        }catch (IOException e) {
                System.out.println(e);
        }
    }
}
