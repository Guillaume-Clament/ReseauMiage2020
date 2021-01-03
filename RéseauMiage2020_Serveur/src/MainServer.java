public class MainServer {
    public static void main(String[] args) {
        Metier1 m1= new Metier1();
        Comprehension c = new Comprehension(m1);
        int port = 28414;
        System.out.println("hey4");
        //TCP
        TCP stcp = new TCP(port, c);
        stcp.travail();

        //UDP
        System.out.println("hey3");
        UDP sUdp = new UDP(port,c);
        sUdp.travailUDP();


    }
}
