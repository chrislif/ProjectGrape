package model;

/**
 *
 * @author chris
 */

public class Account {
    private int accountID;
    private String userName;
    private String nickname;
    private String accountType;
    private String email;
    
    public Account () { }
    
    public Account(int accountID, String userName, String nickname, String accountType) {
        this.accountID = accountID;
        this.userName = userName;
        this.nickname = nickname;
        this.accountType = accountType;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getType() {
        return accountType;
    }

    public void setType(String accountType) {
        this.accountType = accountType;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
