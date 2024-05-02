/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package productsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import domain.Product;

/**
 *
 * @author ASUS
 */
public class AddNewProducts extends HttpServlet {

    public AddNewProducts() {
        // Constructor logic
    }

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
            out.println("<title>Servlet AddNewProducts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewProducts at " + request.getContextPath() + "</h1>");
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

        EntityManager em = (EntityManager) request.getAttribute("javax.persistence.EntityManager");

        UserTransaction utx = (UserTransaction) request.getAttribute("javax.transaction.UserTransaction");

        EntityTransaction transaction = null;
        try {
            utx.begin();
            transaction = em.getTransaction();

            javax.persistence.Query query = em.createNamedQuery("ProductModel.insertProduct");

            Random random = new Random();

            query.setParameter("prodId", Product.NextProductID());
            query.setParameter("courseName", request.getParameter("CourseName"));
            query.setParameter("synopsis", request.getParameter("Synopsis"));
            query.setParameter("price", Double.parseDouble(request.getParameter("Price")));
            query.setParameter("duration", Integer.parseInt(request.getParameter("Duration")));
            query.setParameter("experienceLevel", request.getParameter("ExperienceLevel"));
            query.setParameter("organizer", request.getParameter("Organizer"));
            query.setParameter("contributor", request.getParameter("Contributor"));
            query.setParameter("skillsGained", request.getParameter("SkillsGained"));
            query.setParameter("modules", request.getParameter("Modules"));
            query.setParameter("objective", request.getParameter("Objective"));
            query.setParameter("category", request.getParameter("Category"));
            query.setParameter("rating", random.nextDouble() * 5.0);
            query.setParameter("reviews", random.nextInt(200));

            query.executeUpdate();

            transaction.commit();

            try (PrintWriter error = response.getWriter()) {
                error.println("<!DOCTYPE html>");
                error.println("<html>");
                error.println("<body>");
                error.println("<script type=\"text/javascript\">alert('Product Added Successfully!');");
                error.println("window.open('productAdd.html', '_self');");
                error.println("</script>");
                error.println("</body>");
                error.println("</html>");
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            try (PrintWriter error = response.getWriter()) {
                error.println("<!DOCTYPE html>");
                error.println("<html>");
                error.println("<body>");
                error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                error.println("window.open('productAdd.html', '_self');");
                error.println("</script>");
                error.println("</body>");
                error.println("</html>");
            }
        } finally {
            response.sendRedirect("productAdd.html");
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
