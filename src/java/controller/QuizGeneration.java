/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import data.GrapeDB;
import java.sql.SQLException;
import model.Question;
import java.util.ArrayList;
import model.Test.Quiz;

/**
 *
 * @author Dadvid
 */
public class QuizGeneration {
    
    protected static Quiz generateQuiz(String questionLevel, ArrayList<String> errorList) {
        
        ArrayList<Question> questionList = new ArrayList();
        try {
            questionList = GrapeDB.generateQuestionList(questionLevel);
        } catch (SQLException ex) {
            errorList.add("Generation Error");
            errorList.add(ex.getMessage());
            return null;
        }
        
        
        return null;
    }
    
}
