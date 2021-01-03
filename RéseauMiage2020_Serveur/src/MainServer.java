public class MainServer {
    public static void main(String[] args) {
        Metier1 m1= new Metier1();
        Comprehension c = new Comprehension(m1);
        //TCP Checker
        TCP stcpC = new TCP(28414, c);
        Thread tcpServerC = new Thread(stcpC);
        tcpServerC.start();

        //TCP Manager
        TCP stcpM = new TCP(28415, c);
        Thread tcpServerM = new Thread(stcpM);
        tcpServerM.start();


        //UDP
        UDP sUdp = new UDP(28414,c);
        Thread udpServer = new Thread(sUdp);
        udpServer.start();


    }
}
