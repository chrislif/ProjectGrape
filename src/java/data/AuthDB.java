package data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Account;
import model.Classroom;

/**
 *
 * @author chris
 */
public class AuthDB {
    
    public static String createAccount(Account user, String salt, String hash) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String keyValue = "";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        String query
                = "INSERT INTO account (userName, nickname, accountType, salt, hash, email) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getNickname());
            statement.setString(3, user.getType());
            statement.setString(4, salt);
            statement.setString(5, hash);
            statement.setString(6, user.getEmail());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

        } catch (SQLException sqlEx) {
            throw sqlEx;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.next();
                    keyValue = resultSet.getString(1);
                    
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException ex) {
                throw ex;
            }
        }
        return keyValue;
    }
    
    public static Account loginUser(String userName, String password) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Account user = null;

        String query = "SELECT * FROM account WHERE userName = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            resultSet.next();

            if (compareHash(password, resultSet.getString("salt"), resultSet.getString("hash"))) {
                user = new Account();

                user.setAccountID(resultSet.getInt("accountID"));
                user.setUserName(resultSet.getString("userName"));
                user.setNickname(resultSet.getString("nickname"));
                user.setEmail(resultSet.getString("email"));
                user.setType(resultSet.getString("accountType"));
            }
            
            return user;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    public static Boolean doesUserExist(String userName) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM account WHERE userName = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }

    public static int updateEmail(String userName, String email) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        
        
        String query = "UPDATE account SET email = ? WHERE userName = ?";
        
        try{
           statement = connection.prepareStatement(query);
           statement.setString(1, email);
           statement.setString(2, userName);

           
           return statement.executeUpdate();
           
        }catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    public static int createClassroom(int teacherID, String className) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        Account user = null;
        
        String query = "INSERT INTO classroom (teacherID, className) VALUES (?, ?)";
        
        try{
           statement = connection.prepareStatement(query);
           statement.setInt(1, teacherID);
           statement.setString(2, className);

           
           return statement.executeUpdate();
           
        }catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    
    public static int findClassroomID(String classroomName) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        Classroom classroom = null;
        
        String query = "SELECT classID FROM classroom WHERE className = ?";
        
        try{
           statement = connection.prepareStatement(query);
           statement.setString(1, classroomName);
           resultSet = statement.executeQuery();
           resultSet.next();
           classroom = new Classroom();
           
           classroom.setClassroomID(resultSet.getInt("classID"));
          
           
           return classroom.getClassroomID();
           
        }catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    public static int joinClassroom(int studentID, String classroomName) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        Account user = null;
        
        String query = "INSERT INTO classstudent (classID, studentID) VALUES (?, ?)";
        
        try{
           statement = connection.prepareStatement(query);
           statement.setInt(1, findClassroomID(classroomName));
           statement.setInt(2, studentID);

           
           return statement.executeUpdate();
           
        }catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    public static int updateUserName (String userName, String userN) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        
        String query = "UPDATE account SET userName = ? where userName = ?";
        
        try{
            statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, userN);
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }            
        }
    }
    
    public static int updatePassword (String salt, String hash, String userName) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        
        String query = "UPDATE account SET salt = ?, hash = ? "
                + "where userName = ?";
        
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, salt);
            statement.setString(2, hash);
            statement.setString(3, userName);
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (resultSet != null && statement != null) {
                    resultSet.close();
                    statement.close();
                }
                pool.freeConnection(connection);
            } catch (SQLException e) {
                throw e;
            }            
        }
    }
    
   /* I'm using this post as a reference for the hashing methodology:
    * https://stackoverflow.com/questions/20832008/jsp-simple-password-encryption-decryption
    * and this is the information for reference to the SALT:
    * https://en.wikipedia.org/wiki/Salt_%28cryptography%29
    */
    
    private static Boolean compareHash(String passwordInput, String salt, String hashStored){
        try {
            String hashInput = hashPassword(passwordInput, salt);
            return hashInput.equals(hashStored);
        } catch (NoSuchAlgorithmException ex) {
            return false;
        }
    }
    
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException{
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            md.update(salt.getBytes());
            md.update(password.getBytes());
            
            byte[] byteHash = md.digest();
            return bytesToHex(byteHash);
        } catch (NoSuchAlgorithmException ex) {
            throw ex;
        }
    }
    
   /* This is a borrowed method for changing a byte array to a hex string
    * https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    */
    
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
