package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author chris
 */
public class Public extends HttpServlet {
    
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
                url = "/index.jsp";
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
        String username;
        String password;
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ArrayList<String> errorList = new ArrayList();
        
        Account currentUser = (Account) session.getAttribute("currentUser");
        
        switch (action) {
            case "toLogin":
                url = "/page/auth/login.jsp";
                break;
               
            case "toRegister":
                url = "/page/auth/register.jsp";
                break;
                
            case "toReset":
                url = "/page/auth/reset.jsp";
                break;
                
            case "authorize":
                username = request.getParameter("username");
                password = request.getParameter("password");
                
                if (Authorization.IsValidLogin(username, password, errorList)) {
                    if (Authorization.IsAuthorized(username, password, errorList, currentUser)) {
                        session.setAttribute("currentUser", currentUser);
                        url = "/page/profile.jsp";
                    }
                    else {
                        url = "/page/auth/login.jsp";
                    }
                }
                else {
                    url = "/page/auth/login.jsp";
                }
                
                request.setAttribute("username", username);
                
                break;
               
            case "register":
                username = request.getParameter("username");
                password = request.getParameter("password");
                String passwordCheck = request.getParameter("passwordCheck");
                
                if (Authorization.RegisterUser(username, password, passwordCheck, errorList, currentUser)) {
                    session.setAttribute("currentUser", currentUser);
                    url = "/page/profile.jsp";
                }
                else {
                    url = "/page/auth/register.jsp";
                }
                break;
                
            case "resetPassword":
                url = "/page/auth/reset.jsp";
                break;
                    
            default:
                url = "/index.jsp";
                break;
        }
        
        request.setAttribute("errorList", errorList);
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    public Public() { }
    
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
