import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

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

        try {
            s.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        dp.setData(buffer); // permet de ré init la taille
    }
}
