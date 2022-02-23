package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Assessment;
import model.AssessmentQuestions;
import model.Grade;
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

            Question question;
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

    public static int createAssessment(Assessment assessment) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int keyValue = 0;

        String query
                = "Insert into assessment (assessmentLevel, tag) "
                + "values (?, ?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, assessment.getAssessmentLevel());
            ps.setString(2, assessment.getTag());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs != null) {
                rs.next();
                keyValue = rs.getInt(1);

                for (Question q : assessment.questionList) {
                    addAssessmentQuestion(q, keyValue);
                }
            }
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                if (ps != null & rs != null) {
                    ps.close();
                    rs.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
        return keyValue;
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

            Quiz q = new Quiz();

            if (rs.next()) {
                q.setAssessmentID(rs.getInt("assessmentID"));
                q.setAssessmentLevel(rs.getInt("assessmentLevel"));
                q.setTag(rs.getString("assessmentTag"));
            }

            return q;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public static void addGrade(Grade grade) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int keyValue;

        String query
                = "Insert into grade (accountID, assessmentID) "
                + "values (?, ?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, grade.getAccountID());
            ps.setInt(2, grade.getAssessmentID());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs != null) {
                rs.next();
                keyValue = rs.getInt(1);

                for (Score s : grade.scoreList) {
                    addScore(s, keyValue);
                }
            }
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public static void addScore(Score score, int gradeID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Insert into score (gradeID, questionNumber, userAnswer, isCorrect) "
                + "values (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, gradeID);
            ps.setInt(2, score.getQuestionNumber());
            ps.setString(3, score.getUserAnswer());
            ps.setBoolean(4, score.getIsCorrect());
            ps.executeUpdate();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public static Grade getGrade(int accountID, int assessmentID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "Select * from grade "
                + "Where accountID = ? and assessmentID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessmentID);
            rs = ps.executeQuery();

            Grade g = new Grade();

            if (rs.next()) {
                g.setAccountID(rs.getInt("scoreAccountID"));
                g.setAssessmentID(rs.getInt("scoreAssessmentID"));
            }

            return g;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public static void addAssessmentQuestion(Question question, int assessmentID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Insert into assessmentquestions (assessmentID, questionID) "
                + "values (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assessmentID);
            ps.setInt(2, question.getQuestionID());
            ps.executeUpdate();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
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

                questions.add(aq);
            }

            return questions;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
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
                if (ps != null) {
                    ps.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
    
    public static ArrayList<Grade> getScores(int accountID) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Grade> gradeList = new ArrayList();

        String query = "SELECT s.scoreID, s.isCorrect, g.gradeID, g.accountID, g.assessmentID "
                + "  FROM score s JOIN grade g "
                + "On g.gradeID = s.gradeID "
                + "Where g.AccountID = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, accountID);
            resultSet = statement.executeQuery();

            Grade grade;
            Score score;
            while (resultSet.next()) {
                if (!doesGradeExist(gradeList, resultSet.getInt("g.assessmentID"))) {
                    grade = new Grade();
                    grade.setAccountID(resultSet.getInt("g.accountID"));
                    grade.setAssessmentID(resultSet.getInt("g.assessmentID"));
                    grade.scoreList = new ArrayList();
                    gradeList.add(grade);
                } else {
                    grade = retrieveGradeFromList(gradeList, resultSet.getInt("g.assessmentID"));
                }
                
                score = new Score();
                score.setScoreID(resultSet.getInt("s.scoreID"));
                
                int isCorrectInt = Byte.toUnsignedInt(resultSet.getByte("s.IsCorrect"));
                
                if (isCorrectInt == 1) {
                    score.setIsCorrect(true);
                } else {
                    score.setIsCorrect(false);
                }
                
                grade.scoreList.add(score);
                
                

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
        return gradeList;
    }
    
    private static boolean doesGradeExist(ArrayList<Grade> gradeList, int g) {
        
        boolean doesExist = false;
        
        for(Grade grade : gradeList){
            if (grade.getAssessmentID() == g){
                doesExist = true;
            }
        }
        return doesExist;
    }
    
    private static Grade retrieveGradeFromList(ArrayList<Grade> gradeList, int g) {
        
        for (Grade grade : gradeList) {
            if (grade.getAssessmentID() == g){return grade;}
        }
        
        return null;
    }
}
