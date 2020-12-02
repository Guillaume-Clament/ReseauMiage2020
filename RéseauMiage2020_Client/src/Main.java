public class Main {
    public static void main(String[] args) {
//        int port = 28414;
//        TravailClientTCP tc = new TravailClientTCP(port);
//        tc.travail();

        TravailClientUDP tUdp = new TravailClientUDP();
        tUdp.travailUDP();

    }
}
