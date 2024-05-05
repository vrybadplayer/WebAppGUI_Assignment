/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package productsServlet;

import domain.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author ASUS
 */
public class DeleteProduct extends HttpServlet {

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
//        Product prod = new Product();
//        int ProdID = Integer.parseInt(request.getParameter("ProdID"));
//        Product.deleteRecord(ProdID);
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Delete Product</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<script type=\"text/javascript\">alert('Product record deleted successfully');");
//            out.println("window.open('productDelete.jsp', '_self');");
//            out.println("</script>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        Product prod = new Product();
        int ProdID = Integer.parseInt(request.getParameter("ProdID"));
        System.out.println(ProdID);
        Product.deleteRecord(ProdID);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Delete Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">alert('Product record deleted successfully');");
            out.println("window.open('staff/product/productDelete.jsp', '_self')");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
//        
//        EntityManager em = (EntityManager) request.getAttribute("javax.persistence.EntityManager");
//
//        UserTransaction utx = (UserTransaction) request.getAttribute("javax.transaction.UserTransaction");
//
//        EntityTransaction transaction = null;
//        
//        try {
//            utx.begin();
//            transaction = em.getTransaction();
//
//            javax.persistence.Query query = em.createNamedQuery("ProductModel.deleteProduct");
//
//            query.setParameter("prodId", Integer.parseInt(request.getParameter("ProdID")));
//            
//            //Update
//            query.executeUpdate();
//
//            transaction.commit();
//
//            try (PrintWriter error = response.getWriter()) {
//                error.println("<!DOCTYPE html>");
//                error.println("<html>");
//                error.println("<body>");
//                error.println("<script type=\"text/javascript\">alert('Product Deleted Successfully!');");
//                error.println("window.open('productDelete.jsp', '_self');");
//                error.println("</script>");
//                error.println("</body>");
//                error.println("</html>");
//            }
//        } catch (Exception e) {
//            if (transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            try (PrintWriter error = response.getWriter()) {
//                error.println("<!DOCTYPE html>");
//                error.println("<html>");
//                error.println("<body>");
//                error.println("<script type=\"text/javascript\">alert('Error Occured!');");
//                error.println("window.open('productDelete.jsp', '_self');");
//                error.println("</script>");
//                error.println("</body>");
//                error.println("</html>");
//            }
//        } finally {
//            response.sendRedirect("productDelete.jsp");
//        }
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
