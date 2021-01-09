import client.Checker;
import client.Manager;

public class MainClient {
    public static void main(String[] args) {
        Checker checkUDP = new Checker("CheckUDP", true);
        Checker checkTCP = new Checker("CheckTCP", false);
        Manager manager = new Manager("client.Manager");

        checkTCP.check("Toto", "Toto");


        manager.check("Toto", "Toto");
        manager.add("blah", "blah");
        manager.check("blah", "blah");
        manager.update("blah", "blah2");
        manager.check("blah", "blah2");
        manager.delete("blah", "blah2");
        manager.add("blah2", "blah");
        manager.add("blah2", "blah");
        manager.check("blah", "blah2");


        checkUDP.check("Toto", "Toto");
    }
}
