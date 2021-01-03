package client;

import travail.TravailClientTCP;

public class Manager extends Client {
    public Manager(String nom) {
        super(nom);
        this.travailClient = new TravailClientTCP(Client.portManager);
    }

    public void check(String login, String pwd) {
        this.travailClient.check(login, pwd);
    }

    public void add(String login, String pwd) {
        this.travailClient.add(login, pwd);
    }

    public void delete(String login, String pwd) {
        this.travailClient.delete(login, pwd);
    }

    public void update(String login, String pwd) {
        this.travailClient.update(login, pwd);
    }
}
