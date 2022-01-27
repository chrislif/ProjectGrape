package model;

/**
 *
 * @author chris
 */

enum AccountType {
    STUDENT, 
    TEACHER,
    ADMIN
}

public class Account {
    private int accountID;
    private String userName;
    private String password;
    private String fullName;
    private AccountType accountType;
    
    public Account () { }
    
    public Account(int accountID, String userName, String password, String fullName, AccountType accountType) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AccountType getType() {
        return accountType;
    }

    public void setType(AccountType accountType) {
        this.accountType = accountType;
    }
}
