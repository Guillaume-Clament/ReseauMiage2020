
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {
    private int port;
    private Comprehension comprehension;

    public UDP(int port, Comprehension comprehension) {
        this.port = port;
        this.comprehension = comprehension;
    }

     public void travailUDP() {


        try {
            DatagramSocket s = new DatagramSocket(28414);

            // définition du buffer pour stocker le flux
            byte[] buffer = new byte[1024]; // ne pas dépasser la tail max d'un paquet UDP, 64ko - toute les entêtes (tcp 16) (udp 8 octet)
            //

            /**
             * Param 1 : le buffer
             * Param 2 : la taille
             */
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

            //TODO n°6 faire une bounle while
            while (true) {
                s.receive(dp);

                //extraction des données
                InetAddress ipEmetteur = dp.getAddress();
                int portEmetteur = dp.getPort();
                String messageRecu = new String(dp.getData(), 0, dp.getLength());

                //affichage Métier
                System.out.println("messageRecu= " + messageRecu + "\n"
                        + "numéro de port " + portEmetteur + "\n"
                        + "Adresse IP " + ipEmetteur + "\n");

                //Gestion du client - gestion des threads
                try {

                    String reponse = comprehension.traiter(messageRecu);
                    dp.setData(reponse.getBytes()); // point sur un autre tableau un fois midifié
                    s.send(dp);
                    dp.setData(buffer); // permet de ré init la taille

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
