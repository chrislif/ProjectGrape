package controller;

import java.io.IOException;
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
        
        Account currentUser = (Account) session.getAttribute("currentUser");
        
        switch (action) {
            case "toProfile":
                url = "/page/profile.jsp";
                break;
            
            case "toTest":
                url = "/page/test.jsp";
                break;
                
            case "toDrill":
                url = "/page/drill.jsp";
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
