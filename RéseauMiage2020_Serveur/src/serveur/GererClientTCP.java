package serveur;

import metier.Comprehension;
import metier.LogBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class GererClientTCP implements Runnable{
    private Socket sService;
    private Comprehension comprehension;


    public GererClientTCP(Socket sService, Comprehension comprehension) {
        super();
        this.sService = sService;
        this.comprehension = comprehension;
    }


    public void run(){
        try {
            BufferedReader entreeSocket = new BufferedReader((new InputStreamReader(sService.getInputStream())));
            PrintStream sortieSorcket = new PrintStream(sService.getOutputStream());
            String requete = entreeSocket.readLine();
            String reponse = comprehension.traiter(requete);
            //envoyer la requete au serveur de log
            sortieSorcket.println(reponse);
            LogBuilder.envoyerLog(requete,reponse, sService.getPort(),sService.getInetAddress().getHostAddress(),"TCP");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sService.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
