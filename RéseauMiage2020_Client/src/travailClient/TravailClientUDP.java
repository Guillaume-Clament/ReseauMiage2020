package travailClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TravailClientUDP extends TravailClient{
    private int port;
    public TravailClientUDP(int port) {
        this.port = port;
    }
    public void travail(String message) {
        byte[] buffer = new byte[1024];
        DatagramPacket dpReception = new DatagramPacket(buffer, buffer.length);
        try {

            DatagramSocket s = new DatagramSocket();

            //forge du paquet
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getLocalHost(),this.port);

            //envois
            s.send(dp);
            System.out.println("[UDP] Send message "  + message);

            s.receive(dpReception);
            //réception du message
            InetAddress ipEmetteur = dpReception.getAddress();
            int portEmetteur = dpReception.getPort();
            String reponse = new String(dpReception.getData(), 0, dpReception.getLength());

            System.out.println("[UDP] Receive response for '"+ message+"' => " + reponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


