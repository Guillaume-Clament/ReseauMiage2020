package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Log implements Runnable {
    private int port;

    public Log(int port) {
        this.port = port;
    }


    @Override
    public void run() {
        try {
            ServerSocket sEcoute = new ServerSocket(port);
            System.out.println("[Log] Start server on port " + this.port + "...");

            while (true) {
                //écoute du client
                Socket sService = sEcoute.accept();

                //affichage Métier
                System.out.println("[Log] Receive Log");

                //Gestion du client - gestion des threads
                GererLog gl = new GererLog(sService);
                Thread t = new Thread(gl);
                t.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
