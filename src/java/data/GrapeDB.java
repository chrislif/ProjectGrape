package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Question;

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
    
}
