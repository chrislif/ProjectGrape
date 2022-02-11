package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Question;

/**
 *
 * @author chris
 */
public class Private extends HttpServlet{
    
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
                break;
            
            case "toTest":
                url = "/page/assessments/test.jsp";
                break;
                
            case "toQuiz":
                url="/page/assessments/quiz.jsp";
                break;
                
            case "generateQuiz":
                String questionLevel = request.getParameter("questionLevels");;
                ArrayList<Question> questionList = new ArrayList();
                
                questionList = QuizGeneration.generateQuiz(questionLevel, errorList);
                
                String questionListJSON = gson.toJson(questionList);
                request.setAttribute("questionList", questionListJSON);
                
                url="/page/assessments/quiz.jsp";
                break;
         
            case "toDrill":
                url = "/page/assessments/drill.jsp";
                break;
            case "toClass":
                url = "/page/class.jsp";
                break;
                
            case "logout":
                url = "/page/auth/login.jsp";
                session.setAttribute("currentUser", null);
                break;
                
            default:
                url = "/page/auth/login.jsp";
                break;
        }
       
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    public Private() { }
    
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
