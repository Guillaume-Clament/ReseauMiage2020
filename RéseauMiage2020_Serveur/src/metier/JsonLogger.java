package metier;

import javax.json.*;
import java.io.*;
import java.util.Date;

public class JsonLogger {
    String path = "logs.json";

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
    public static void log(String host, int port, String proto, String type, String login, String result) {
        JsonLogger logger = getLogger();
        try {
            File file = new File(logger.path);
            if(!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            JsonArrayBuilder builder = Json.createArrayBuilder();

            if(file.length() > 0) {
                // read old content
                FileInputStream fi = new FileInputStream(file);

                JsonReader jr = Json.createReader(fi);

                JsonArray old = jr.readArray();
                for(int i = 0; i < old.size(); i++) {
                    builder.add(old.get(i));
                }

                jr.close();
                fi.close();
            }

            // add new content
            builder.add(logger.reqToJson(host, port, proto, type, login, result));

            // write new content
            FileOutputStream fr = new FileOutputStream(file);
            JsonWriter jw = Json.createWriter(fr);

            jw.writeArray(builder.build());

            jw.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
