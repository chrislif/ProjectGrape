/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.GrapeDB;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Question;

/**
 *
 * @author Dadvid
 */
public class QuestionPool {
    
    protected static ArrayList<String> addQuestion(int newQLevel, String newQText, String newQAnswer, String newQType, ArrayList<String> errorList) {
        
        boolean isValid = false;
        
        int tempID = 0;
        
        try {
            GrapeDB.createQuestion(new Question(tempID, newQLevel, newQText, newQAnswer, newQType));
            
        } catch (SQLException ex) {
            errorList.add("Error Adding to DB");
        }
        return errorList;
    }
}
