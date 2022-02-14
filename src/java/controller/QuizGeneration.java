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
        
        ArrayList<Question> questionList = createQuestionList(questionLevel, errorList);
        
        Quiz newQuiz = new Quiz(0, 0, "addition", questionList);
        
        return newQuiz;
    }
    
    protected static ArrayList<Question> createQuestionList(String questionLevel, ArrayList<String> errorList) {
        try {
            return GrapeDB.generateQuestionList(questionLevel);
        } catch (SQLException ex) {
            errorList.add("Generation Error");
            errorList.add(ex.getMessage());
            return null;
        }
    }
}
