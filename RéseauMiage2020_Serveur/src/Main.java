public class Main {
    public static void main(String[] args) {
        Metier1 m1= new Metier1();
        Comprehension c = new Comprehension(m1);
        int port = 28414;
        TCP stcp = new TCP(port, c);
        stcp.travail();

    }
}
