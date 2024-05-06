/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package productsServlet;

import dataAccess.reviewsDA;
import domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

/**
 *
 * @author ASUS
 */
public class reviewServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reviewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reviewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
        
        Customer customer = Customer.SearchCustomer(Integer.parseInt(request.getParameter("CustID")));
        String CustName = customer.getCustName();
        
        boolean errorExist = false;

        //Rating Checking
        do {
            try {
                if (request.getParameter("Rating").equals("")) { //check for empty
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Rating cannot be empty!');");
                        error.println("window.open('reviews.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (Double.parseDouble(request.getParameter("Rating")) > 5.0 || Double.parseDouble(request.getParameter("Rating")) < 0.0) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Rating can only be between 0.0 and 5.0!');");
                        error.println("window.open('reviews.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else {
                    errorExist = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                    error.println("window.open('reviews.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        //Comment Checking
        do {
            try {
                if (request.getParameter("Comment").equals("")) { //check for empty
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Comment cannot be empty!');");
                        error.println("window.open('reviews.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                    error.println("window.open('reviews.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);
        
        reviewsDA.InsertReviews(Integer.parseInt(request.getParameter("ProdID")), CustName, request.getParameter("Comment"), Double.parseDouble(request.getParameter("Rating")));
        
        try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Review has been added!');");
                    error.println("window.open('reviews.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
        
        response.sendRedirect("reviews.jsp?ProdID=" + request.getParameter("ProdID"));
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
