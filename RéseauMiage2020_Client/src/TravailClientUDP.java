import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TravailClientUDP {

    public void travailUDP() {
        byte[] buffer = new byte[1024];
        DatagramPacket dpReception = new DatagramPacket(buffer, buffer.length);
        try {

            DatagramSocket s = new DatagramSocket();
            String message = "CHK Toto Toto";

            //forge du paquet
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getLocalHost(),28414);

            //envois
            s.send(dp);
            System.out.println("hey");

            s.receive(dpReception);
            //réception du message
            InetAddress ipEmetteur = dpReception.getAddress();
            int portEmetteur = dpReception.getPort();
            String messageRecu = new String(dpReception.getData(), 0, dpReception.getLength());

            System.out.println("messageRecu= " + messageRecu + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
