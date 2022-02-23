package controller;

import com.google.gson.Gson;
import data.AuthDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Grade;
import model.Test.Quiz;

/**
 *
 * @author chris
 */
public class Private extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url;
        String action = request.getParameter("action");

        switch (action) {
            default:
                url = "/page/auth/login.jsp";
                break;
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        PrintWriter responseOut = response.getWriter();
        ArrayList<String> errorList = new ArrayList();
        String message = "";
        Gson gson = new Gson();

        Account currentUser = (Account) session.getAttribute("currentUser");

        switch (action) {
            case "toProfile":
                url = "/page/profile.jsp";
                
                ArrayList<Grade> gradeList = Grading.retrieveGrades(currentUser.getAccountID());
                ArrayList<Double> grades = Grading.processGrades(gradeList);
                
                double finalGrade = Grading.getFinalGrade(grades);
                
                request.setAttribute("finalGrade", finalGrade);

                request.setAttribute("grades", grades);
                request.setAttribute("gradeList", gradeList);
                
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "updateEmail":
                String email = request.getParameter("emailInput");
                url = "/page/profile.jsp";

                try {
                    AuthDB.updateEmail(currentUser.getUserName(), email);
                    currentUser.setEmail(email);
                    message = "Email changed!";

                } catch (Exception ex) {
                    errorList.add("Error");
                }
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "updateUserName":
                String userN = request.getParameter("userName");

                if (!userN.isEmpty()) {
                    try {
                        AuthDB.updateUserName(userN, currentUser.getUserName());
                        currentUser.setUserName(userN);
                        message = "User Name changed!";
                        
                    } catch (Exception ex) {
                        errorList.add("Error");

                    }
                } else {
                    errorList.add("User Name cannot be empty!");
                }

                url = "/page/profile.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);

                break;

            case "updatePassword":
                String password = request.getParameter("password");

                if (!password.isEmpty()) {
                        String hash;
                        String salt = Authorization.randomSalt();

                        try {
                            hash = AuthDB.hashPassword(password, salt);
                            AuthDB.updatePassword(salt, hash, currentUser.getUserName());
                            message = "password updated!";
                            
                        } catch (NoSuchAlgorithmException ex) {
                            errorList.add("Error: Unable to encrypt password");
                        } catch (Exception ex){
                            errorList.add("Error changing password");
                        }
                }
                
                url = "/page/profile.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);

                break;

            case "toTest":
                url = "/page/assessments/test.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "toQuiz":
                url = "/page/assessments/quiz.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "generateQuiz":
                String questionLevel = request.getParameter("questionLevels");
                String questionType = request.getParameter("questionType");

                Quiz newQuiz = Generation.generateQuiz(questionLevel, questionType, errorList);
                String questionListJSON = gson.toJson(newQuiz);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                responseOut.print(questionListJSON);
                responseOut.flush();
                break;

            case "storeScore":
                String gradeJSON = request.getParameter("gradeJSON");
                Boolean isStored = Grading.storeGrade(gradeJSON, currentUser);

                responseOut.print(isStored.toString());
                responseOut.flush();
                break;

            case "toDrill":
                url = "/page/assessments/drill.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "toClass":
                url = "/page/class.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "toAddQuestion":
                url = "/page/teacher/addQuestion.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "toQuestionPool":
                url = "/page/teacher/questionPool.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "addQuestion":
                url = "/page/teacher/addQuestion.jsp";

                String qText = request.getParameter("questionText");
                String qAnswer = request.getParameter("questionAnswer");
                int qLevel = Integer.parseInt(request.getParameter("questionLevels"));
                String qType = request.getParameter("tag");

                errorList = QuestionPool.addQuestion(qLevel, qText, qAnswer, qType, errorList);
                
                request.setAttribute("errorList", errorList);
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "logout":
                url = "/page/auth/login.jsp";
                currentUser = null;
                session.setAttribute("currentUser", currentUser);
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            default:
                url = "/page/auth/login.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
        }
        session.setAttribute("currentUser", currentUser);
        session.setAttribute("message", message);

        //getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    public Private() {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "The private servlet manager for MathWiz";
    }

}
