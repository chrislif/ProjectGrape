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
import model.AssessmentQuestions;
import model.Question;
import model.Score;
import model.Test.Quiz;

/**
 *
 * @author chris
 */
public class GrapeDB {

    public static ArrayList<Question> generateQuestionList(String questionLevel, String questionTag) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Question> questionList = new ArrayList();

        String query = "SELECT * FROM question WHERE questionLevel = ? AND tag = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, questionLevel);
            statement.setString(2, questionTag);
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

    public static void createAssessment(Assessment assessment) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Insert into assessment (assessmentID, assessmentLevel, tag) "
                + "values (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessment.getAssessmentID());
            ps.setInt(2, assessment.getAssessmentLevel());
            ps.setString(3, assessment.getTag());
            ps.executeUpdate();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (SQLException ex) {
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

            if (rs.next()) {
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

            } catch (Exception e) {
                throw e;
            }
        }
    }

    public static void addScore(Score score) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Insert into score (accountID, assessmentID, gradePercent) "
                + "valus (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, score.getAccountID());
            ps.setInt(2, score.getAssessmentID());
            ps.setDouble(3, score.getGradePercent());
            ps.executeUpdate();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public static Score getScore(int accountID, int assessmentID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "Select * from score "
                + "Where accountID = ? and assessmentID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessmentID);
            rs = ps.executeQuery();

            Score s = null;

            if (rs.next()) {
                s.setAccountID(rs.getInt("scoreAccountID"));
                s.setAssessmentID(rs.getInt("scoreAssessmentID"));
                s.setGradePercent(rs.getDouble("scorePercent"));

            }

            return s;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);

            } catch (Exception e) {
                throw e;
            }
        }
    }

    public static void addAssessmentQuesiton(AssessmentQuestions assessmentQuestion) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Insert into assessmentquestions (assessmentID, questionID) "
                + "values (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessmentQuestion.getAssessmentID());
            ps.setInt(2, assessmentQuestion.getQuestionID());
            ps.executeUpdate();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public static ArrayList<AssessmentQuestions> getAssessmentQuestions(int assessmentID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<AssessmentQuestions> questions = new ArrayList();
        
        String query
                = "select questionID, questionText from assessmentquestions "
                + "Where assessmentID = ? "
                + "Inner Join question on assessmentquestions.questionID = question.questionID";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessmentID);
            rs = ps.executeQuery();

            AssessmentQuestions aq = null;

            while (rs.next()) {
                aq.setAssessmentID(rs.getInt("assessmentID"));
                aq.setQuestionID(rs.getInt("questionID"));
                
                questions.add(aq);
            }

            return questions;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);

            } catch (Exception e) {
                throw e;
            }
        }
    }
    
    public static void createQuestion(Question question) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Insert into question (questionLevel, questionText, questionAnswer, tag) "
                + "values (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, question.getQuestionLevel());
            ps.setString(2, question.getQuestionText());
            ps.setString(3, question.getQuestionAnswer());
            ps.setString(4, question.getTag());
            ps.executeUpdate();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
}
