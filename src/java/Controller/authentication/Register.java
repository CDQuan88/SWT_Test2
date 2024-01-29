/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.authentication;

import DAO.AccountDAO;
import DAO.CartDAO;
import DAO.CategoryDAO;
import DAO.CheckDAO;
import DAO.DAO;
import DAO.ProductDAO;
import Model.Account;
import Model.Check;
import Model.Pagination.Pagination;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toden
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAO CheckDao;
    DAO Adao;
    Pagination Page;
    public void init(){
        Adao = new AccountDAO();
        CheckDao = new CheckDAO();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("Account",null);
        List<Check> listCheck = CheckDao.getAllChecks();
        session.setAttribute("listCheck", listCheck);
        response.sendRedirect("register.jsp");
       
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String repass =request.getParameter("repassword");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int check_id = Integer.parseInt(request.getParameter("check"));
        String answer = request.getParameter("answer");
        
        List<Check> listCheck = CheckDao.getAllChecks();
        session.setAttribute("listCheck", listCheck);
        
        PrintWriter out = response.getWriter();
        out.println(repass);
        out.println(password);
if (!password.equals(repass)) {
    request.setAttribute("mess1", "Error password");
    request.getRequestDispatcher("register.jsp").forward(request, response);
} else if (Adao.findAccByEmail(email) != null && Adao.findAccByEmail(email).getAccountId() > 0) {
    request.setAttribute("mess", "Email was registered");
    request.getRequestDispatcher("register.jsp").forward(request, response);
} else {
    Account acc = Adao.addAcc(account, password, name, phone, address, email, check_id, answer);
    session.setAttribute("Account", acc);
    response.sendRedirect("ProductList");
}
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
