package controller;

import com.google.gson.Gson;
import data.AuthDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Grade;
import model.Score;
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
        HttpSession session = request.getSession();

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
        ArrayList<String> errorList = new ArrayList();
        Gson gson = new Gson();

        Account currentUser = (Account) session.getAttribute("currentUser");

        switch (action) {
            case "toProfile":
                url = "/page/profile.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "updateEmail":
                String email = request.getParameter("emailInput");
                currentUser.setEmail(email);
                url = "/page/profile.jsp";
                try {
                    AuthDB.updateEmail(currentUser.getUserName(), email);
                } catch (Exception ex) {
                    errorList.add("Error");
                }
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

                Quiz newQuiz = QuizGeneration.generateQuiz(questionLevel, questionType, errorList);
                String questionListJSON = gson.toJson(newQuiz.questionList);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                PrintWriter responseOut = response.getWriter();
                responseOut.print(questionListJSON);
                responseOut.flush();
                break;

            case "storeScore":
                String scoreListJSON = request.getParameter("scoreListJSON");
                Grade newGrade = Grading.createGrade(scoreListJSON);
                
                
                
                break;
                
            case "toDrill":
                url = "/page/assessments/drill.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "toClass":
                url = "/page/class.jsp";
                session.setAttribute("accountType", currentUser.getType());
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            case "logout":
                url = "/page/auth/login.jsp";
                session.setAttribute("currentUser", null);
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

            default:
                url = "/page/auth/login.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
        }
        session.setAttribute("currentUser", currentUser);

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
        return "Short description";
    }
}
