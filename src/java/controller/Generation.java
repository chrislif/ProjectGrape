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
public class Generation {
    
    protected static ArrayList<Question> createQuestionList(String questionLevel, String questionType, ArrayList<String> errorList) {
        try {
            return GrapeDB.generateQuestionList(questionLevel, questionType);
        } catch (SQLException ex) {
            errorList.add("Generation Error");
            errorList.add(ex.getMessage());
            return null;
        }
    }
    
    protected static Quiz generateQuiz(String quizLevel, String quizType, ArrayList<String> errorList) {
        ArrayList<Question> questionList = createQuestionList(quizLevel, quizType, errorList);
        
        Quiz newQuiz = createAndStoreQuiz(quizLevel, quizType, questionList, errorList);
        
        return newQuiz;
    }
    
    protected static Quiz createAndStoreQuiz(String quizLevel, String quizType, ArrayList<Question> questionList, ArrayList<String> errorList) {
        Quiz createdQuiz = new Quiz(0, Integer.parseInt(quizLevel), quizType, questionList);
        
        try {
            int quizID = GrapeDB.createAssessment(createdQuiz);
            createdQuiz.setAssessmentID(quizID);
        }
        catch (SQLException ex) {
            errorList.add("Generation Error");
            errorList.add(ex.getMessage());
            return null;
        }
        
        return createdQuiz;
    }
}
