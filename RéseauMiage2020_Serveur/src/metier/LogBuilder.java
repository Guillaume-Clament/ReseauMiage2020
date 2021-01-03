package metier;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class LogBuilder {
    public static void envoyerLog(String requete, String reponse, int port, String adresse, String protocol){

        String [] tab = requete.split(" ");
        String commande =tab[0];
        String login = tab[1];
        String log = String.join(" ",adresse, String.valueOf(port), protocol, commande, login, reponse);

        try {
            Socket socket = new Socket("localhost",3244);
            try {
                PrintStream sortieSorcket = new PrintStream(socket.getOutputStream());
                sortieSorcket.println(log);
                System.out.println("[Log] Send log:  " + log);
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
