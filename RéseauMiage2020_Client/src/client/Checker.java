package client;

import travailClient.TravailClientTCP;
import travailClient.TravailClientUDP;

public class Checker extends Client{

    public Checker(String nom, boolean isUDP) {
        super(nom);

        if(isUDP) {
            this.travailClient = new TravailClientUDP(Client.portChecker);
        } else {
            this.travailClient = new TravailClientTCP(Client.portChecker);
        }
    }

    public void check(String login, String pwd) {
        this.travailClient.check(login, pwd);
    }
}
