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
    
    protected static Quiz generateQuiz(String questionLevel, String questionType, ArrayList<String> errorList) {
        ArrayList<Question> questionList = createQuestionList(questionLevel, questionType, errorList);
        
        return new Quiz(0, 0, "Addition", questionList);
    }
    
    protected static ArrayList<Question> createQuestionList(String questionLevel, String questionType, ArrayList<String> errorList) {
        try {
            return GrapeDB.generateQuestionList(questionLevel);
        } catch (SQLException ex) {
            errorList.add("Generation Error");
            errorList.add(ex.getMessage());
            return null;
        }
    }
}
