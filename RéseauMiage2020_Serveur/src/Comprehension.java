import javax.swing.*;

public class Comprehension {

    private Metier1 metier1;

    public Comprehension(Metier1 metier1) {
        this.metier1 = metier1;
    }

    public String traiter(String requete){

        String [] tab = requete.split(" ");
        String reponse = "Error, ne fonctionne pas";
        //TODO n°1: voir si on renvois un message a l'utilisateur sur les parametres, ou si c'est lié à la forge de la trame
        if(tab.length >= 4){
            System.out.println("erreur parametre");
        }
        String commande =tab[0];
        String login = tab[1];
        String password = tab[2];

        // redirection de la commande
        switch (commande.toUpperCase()){
            case "CHK":{
                boolean retourmetier = metier1.tester(login, password);
                if (retourmetier == true){
                    reponse = "Good" ;
                }
                else {
                    reponse = "Bad";
                }
            }
            break;
            //TODO n°2: vérifier si on retourne les erreurs, attention au coté utilisateur
            case "ADD":{
                boolean retourmetier = metier1.creer(login, password);
                if (retourmetier == true){
                    reponse = "DONE" ;
                }
            }
            break;
            //TODO n°3: vérifier si on retourne les erreurs, attention au coté utilisateur
            case "DEL":{
                boolean retourmetier = metier1.supprimer(login, password);
                if (retourmetier == true){
                    reponse = "DONE" ;
                }
            }
            break;
            //TODO n°4: vérifier si on retourne les erreurs, attention au coté utilisateur
            case "MOD":{
                boolean retourmetier = metier1.mettreAJour(login, password);
                if (retourmetier == true){
                    reponse = "DONE" ;
                }
            }
            break;

        }
        return reponse;

    }
}
