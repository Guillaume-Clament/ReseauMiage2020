package serveur;

import metier.Comprehension;
import metier.JsonLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.net.Socket;
import java.util.Date;

public class GererLog implements Runnable {

    private Socket sService;


    public GererLog(Socket sService) {
        super();
        this.sService = sService;
    }
    // host, port, Protocole , Type de requete, login utilisé, resultat )


    public void run(){
        try {
            BufferedReader entreeSocket = new BufferedReader((new InputStreamReader(sService.getInputStream())));
            String requete = entreeSocket.readLine();
            log(requete);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sService.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void log (String requete){
        String[] requestParsed = requete.split(" ");
        if(requestParsed.length != 6){
            System.out.println(" log request wrong format");
        }else{
            JsonLogger.log(requestParsed[0], Integer.parseInt(requestParsed[1]),requestParsed[2],requestParsed[3],requestParsed[4],requestParsed[5]);
        }


    }

}


