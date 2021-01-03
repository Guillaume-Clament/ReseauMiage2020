package serveur;//gestion de la communication

import metier.Comprehension;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP implements Runnable{
    private int port;
    private Comprehension comprehension;

    public TCP(int port, Comprehension comprehension) {
        this.port = port;
        this.comprehension = comprehension;
    }

    //TODO n°5: vérifier les messages d'erreur des try catch

    public void run() {
        try {
            //ouverture du service
            ServerSocket sEcoute = new ServerSocket(port);

            System.out.println("[TCP] Start server on port " + this.port + "...");

            while (true) {
                //écoute du client
                Socket sService = sEcoute.accept();

                //affichage Métier
                System.out.println("[TCP] Receive message");

                //Gestion du client - gestion des threads
                GererClientTCP gc = new GererClientTCP(sService,comprehension);
                Thread t = new Thread(gc);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
