package controller;

import data.AuthDB;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.Account;
import java.util.ArrayList;
import java.util.Random;

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
    
    protected static Account authorizeUser(String userName, String password, ArrayList<String> errorList) {
        try {
            return AuthDB.loginUser(userName, password);
        } catch (SQLException ex) {
            errorList.add("Invalid Credentials");
            //errorList.add(ex.getMessage());
            return null;
        }
    }
    
    protected static Account RegisterUser(String username, String password, String passwordCheck, String userType, ArrayList<String> errorList) {
        if (!password.equals(passwordCheck)) {
            errorList.add("Password do not match, please reenter");
            return null;
        }
        
        try {
            if (AuthDB.doesUserExist(username)) {
                errorList.add("Username invalid");
                return null;
            }
        }
        catch (SQLException ex) {
            errorList.add(ex.getMessage());
            return null;
        }
        
        
        Account user = new Account();
        user.setUserName(username);
        user.setType(userType);
        
        String hash;
        String salt = randomSalt();
        
        try {
            hash = AuthDB.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException ex) {
            errorList.add("Error: Unable to encrypt password");
            return null;
        }
        
        try {
            AuthDB.createAccount(user, salt, hash);
            Account currentUser = user;
        }
        catch (SQLException ex) {
            errorList.add(ex.getMessage());
            return null;
        }
        
        return user;
    }
    
    protected static void parseClassroom(Account account, String classroomName){
        if(account.getType() == "Teacher"){
            createClassroom(account, classroomName);
        }
        else if(account.getType() == "Student"){
            joinClassroom(account, classroomName);
        }
        else{
            
        }
    }
    
    private static void createClassroom(Account account, String classroomName){
        
    }
    
    private static void joinClassroom(Account account, String classroomName){
        
    }
    
    private static String randomSalt(){
        String alphanumericList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * alphanumericList.length());
            salt.append(alphanumericList.charAt(index));
        }
        return salt.toString();
    }
}
