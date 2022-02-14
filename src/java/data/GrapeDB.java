package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.Assessment;
import model.Question;
import model.Test.Quiz;

/**
 *
 * @author chris
 */
public class GrapeDB {
    
    public static ArrayList<Question> generateQuestionList(String questionLevel) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        ArrayList<Question> questionList = new ArrayList();
        
        String query = "SELECT * FROM question WHERE questionLevel = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, questionLevel);
            resultSet = statement.executeQuery();
            
            Question question = null;
            
            
            while (resultSet.next()) {
                question = new Question();
                question.setQuestionID(resultSet.getInt("questionID"));
                question.setQuestionLevel(resultSet.getInt("questionLevel"));
                question.setQuestionText(resultSet.getString("questionText"));
                question.setQuestionAnswer(resultSet.getString("questionAnswer"));
                question.setTag(resultSet.getString("tag"));
                
                questionList.add(question);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
        return questionList;
    }
    
    public static void createAssessment(Assessment assessment, int assessmentLevel, String tag) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;  
        
        String query 
                = "Insert into assessment (assessmentID, assessmentLevel, tag) "
                + "valus (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessment.getAssessmentID());
            ps.setInt(2, assessment.getAssessmentLevel());
            ps.setString(3, assessment.getTag());
            ps.executeUpdate();
            
        } catch (SQLException sqlEx){
            throw sqlEx;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (SQLException ex){
                throw ex;
            }
        }
   }

    public static Assessment getAssessment(int assessmentID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "Select * from assessment "
                + "Where assessmentID = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessmentID);
            rs = ps.executeQuery();
            
            Assessment as = null;
            
            if (rs.next()){
                as.setAssessmentID(rs.getInt("assessmentID"));
                as.setAssessmentLevel(rs.getInt("assessmentLevel"));
                as.setTag(rs.getString("assessmentTag"));
            }
            
            return as;
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
                
            }catch (Exception e) {
                throw e;
            }
        }
    }
}
