/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
    
    protected static Boolean IsAuthorized(String username, String password, ArrayList<String> errorList) {
        Boolean isAuthorized = true;
        
        
        
        return isAuthorized;
    }
    
    protected static Boolean RegisterUser(String username, String password, String passwordCheck) {
        
        
        
        return false;
    }
}
