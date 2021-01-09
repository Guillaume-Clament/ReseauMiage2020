package client;

import travail.TravailClient;

public abstract class Client {
    public static int portChecker = 28414;
    public static int portManager = 28415;

    protected String nom;

    TravailClient travailClient;

    public Client(String nom) {
        this.nom = nom;
    }
}
