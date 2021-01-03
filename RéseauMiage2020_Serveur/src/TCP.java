//gestion de la communication

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
                GererClientTCP gc = new GererClientTCP(sService,comprehension);
                Thread t = new Thread(gc);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
