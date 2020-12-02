import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TravailClient {
    private int port;

    public TravailClient(int port) {
        this.port = port;
    }

    public void travail(){

        try {
            Socket socket = new Socket("localhost",port);
            try {
                BufferedReader entreeSocket = new BufferedReader((new InputStreamReader(socket.getInputStream())));
                PrintStream sortieSorcket = new PrintStream(socket.getOutputStream());
                sortieSorcket.println("CHK Toto Toto");
                String reponse = entreeSocket.readLine();
                System.out.println("Réponse = " + reponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
