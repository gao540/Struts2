package VO;

public class User {
    private String account;
    private String password;
    private String username;
    public User(){
        super();
    }
    public User(String account,String password,String name){
        this.account=account;
        this.password=password;
        this.username=name;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }
}
