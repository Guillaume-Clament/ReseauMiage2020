package travailClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TravailClientTCP extends TravailClient {
    private int port;

    public TravailClientTCP(int port) {
        this.port = port;
    }

    public void travail(String message){
        try {
            Socket socket = new Socket("localhost",port);
            try {
                BufferedReader entreeSocket = new BufferedReader((new InputStreamReader(socket.getInputStream())));
                PrintStream sortieSorcket = new PrintStream(socket.getOutputStream());
                sortieSorcket.println(message);
                System.out.println("[TCP] Send message " + message);
                String reponse = entreeSocket.readLine();
                System.out.println("[TCP] Receive reponse for '"+ message+"' => " + reponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
