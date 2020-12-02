//gestion de la communication

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.PriorityQueue;

public class TCP {
    private int port;
    private Comprehension comprehension;

    public TCP(int port, Comprehension comprehension) {
        this.port = port;
        this.comprehension = comprehension;
    }

    //TODO n°5: vérifier les messages d'erreur des try catch

    public void travail() {
        try {
            //ouverture du service
            ServerSocket sEcoute = new ServerSocket(port);

            while (true) {
                //écoute du client
                Socket sService = sEcoute.accept();

                //Gestion du client - gestion des threads
                try {
                    BufferedReader entreeSocket = new BufferedReader((new InputStreamReader(sService.getInputStream())));
                    PrintStream sortieSorcket = new PrintStream(sService.getOutputStream());
                    String requete = entreeSocket.readLine();
                    String reponse = comprehension.traiter(requete);
                    sortieSorcket.println(reponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sService.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
