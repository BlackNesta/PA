package ServerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    public ClientThread (Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Your request is: " + request + "!";
            if (request.equals("exit")) {
                socket.close();
            }
            else if (request.equals("stop")) {
                raspuns = "Server stopped";
                out.println(raspuns);
                out.flush();
                socket.close();
                System.exit(0);
            }
            else {
                out.println(raspuns);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Comunication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
