package travailClient;

public abstract class TravailClient {
    abstract void travail(String message);

    public void check(String login, String pwd) {
        travail("CHK " + login + " " + pwd);
    }

    public void add(String login, String pwd) {
        travail("ADD " + login + " " + pwd);
    }

    public void delete(String login, String pwd) {
        travail("DEL " + login + " " + pwd);
    }

    public void update(String login, String newPwd) {
        travail("MOD " + login + " " + newPwd);
    }
}
