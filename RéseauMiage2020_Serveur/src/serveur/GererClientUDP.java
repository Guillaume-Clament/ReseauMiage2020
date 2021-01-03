package serveur;

import metier.Comprehension;
import metier.LogBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.StringJoiner;

public class GererClientUDP implements Runnable{


    private Comprehension comprehension;
    private String messageRecu;
    DatagramPacket dp;
    byte[] buffer = new byte[1024];
    DatagramSocket s;

    public GererClientUDP(DatagramPacket dp, String messageRecu, DatagramSocket s, Comprehension comprehension) {
        super();
        this.s = s;
        this.dp = dp;
        this.messageRecu = messageRecu;
        this.comprehension = comprehension;
    }

    public void run(){

        String reponse = comprehension.traiter(messageRecu);

        dp.setData(reponse.getBytes()); // point sur un autre tableau un fois midifié
        //envoyer la requete au serveur de log
        try {
            s.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogBuilder.envoyerLog(messageRecu,reponse, s.getPort(),s.getInetAddress().getHostAddress(),"UDP");
        dp.setData(buffer); // permet de ré init la taille
    }
}
