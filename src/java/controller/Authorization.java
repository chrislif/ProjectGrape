package controller;

import data.AuthDB;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.Account;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Authorization {
    
    protected static Boolean IsValidLogin(String username, String password, ArrayList<String> errorList) {
        Boolean isValid = true;
        
        if(username.isEmpty()) {
            errorList.add("Please enter a Username");
            isValid = false;
        }
        
        if(password.isEmpty()) {
            errorList.add("Please enter a Password");
            isValid = false;
        }
        
        return isValid;
    }
    
    protected static Boolean IsAuthorized(String userName, String password, ArrayList<String> errorList, Account currentUser) {
        try {
            currentUser = AuthDB.loginUser(userName, password);
            return true;
        } catch (SQLException ex) {
            errorList.add("Invalid Credentials");
            errorList.add(ex.getMessage());
            return false;
        }
    }
    
    protected static Boolean RegisterUser(String username, String password, String passwordCheck, String userType, ArrayList<String> errorList, Account currentUser) {
        if (!password.equals(passwordCheck)) {
            errorList.add("Password do not match, please reenter");
            return false;
        }
        
        Account user = new Account();
        user.setUserName(username);
        user.setType(userType);
        
        String hash;
        String salt = "123456";
        
        try {
            hash = AuthDB.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException ex) {
            errorList.add("Error: Unable to encrypt password");
            return false;
        }
        
        try {
            AuthDB.createAccount(user, salt, hash);
            currentUser = user;
        }
        catch (SQLException ex) {
            errorList.add(ex.getMessage());
            return false;
        }
        
        return true;
    }
}
