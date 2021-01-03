package metier;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class JsonLogger {
    // Attributs à compléter


    /**
     * Constructeur à compléter
     */
    private JsonLogger() {

    }

    /**
     * Transforme une requête en Json
     *
     * @param host machine client
     * @param port port sur la machine client
     * @param proto protocole de transport utilisé
     * @param type type de la requête
     * @param login login utilisé
     * @param result résultat de l'opération
     * @return un objet Json correspondant à la requête
     */
    private JsonObject reqToJson(String host, int port, String proto, String type, String login, String result) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("host", host)
                .add("port", port)
                .add("proto", proto)
                .add("type", type)
                .add("login", login)
                .add("result", result)
                .add("date", new Date().toString());

        return builder.build();
    }

    /**
     *  singleton
     */
    private static JsonLogger logger = null;

    /**
     * récupération du logger qui est créé si nécessaire
     *
     * @return le logger
     */
    private static JsonLogger getLogger() {
        if (logger == null) {
            logger = new JsonLogger();
        }
        return logger;
    }

    /**
     * méthode pour logger
     *
     * @param host machine client
     * @param port port sur la machine client
     * @param proto protocole de transport utilisé
     * @param type type de la requête
     * @param login login utilisé
     * @param result résultat de l'opération
     */
    public static void log(String host, int port, String proto, String type, String login, String result) throws IOException {
        JsonLogger logger = getLogger();
        // à compléter
        FileReader fr = new FileReader("log.json");
        JsonReader jr = new JsonReader(fr);
        FileWriter file = new FileWriter("log.json");



    }

}
