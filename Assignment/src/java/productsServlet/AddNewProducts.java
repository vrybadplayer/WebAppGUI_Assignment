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
import java.util.Arrays;
import java.util.List;

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

            //Validation
            boolean errorExist = false;

            //Course Name Validation
            do {
                try {
                    if (request.getParameter("CourseName").equals("")) { //check for empty course name
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Course Name cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
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
                        error.println("window.open('productAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Synopsis Validation
            do {
                try {
                    if (request.getParameter("Synopsis").equals("")) { //check for empty synopsis
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Synopsis cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
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
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Price Validation
            do {
                try {
                    if (request.getParameter("Price").equals("")) { //Check empty Price
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Price cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (NumberFormatException e) { //Catch if not number
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Price can only contain numbers!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Duration Validation
            do {
                try {
                    if (request.getParameter("Duration").equals("")) { //Check empty Duration
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Duration cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (Integer.parseInt(request.getParameter("Duration")) > 52) { //Check if more than 1 year
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Duration is too long!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (NumberFormatException e) { //Catch if not number
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Price can only contain numbers!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Experience Level Validation
            do {
                try {
                    if (request.getParameter("ExperienceLevel").equals("")) { //Check empty Duration
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Experience Level cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("ExperienceLevel").length() > 20) { // cannot have more than 20 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Experience Level text is too long!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Organizer Validation
            do {
                try {
                    if (request.getParameter("Organizer").equals("")) { //Check empty organizer
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Organizer cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("Organizer").length() > 20) { // cannot have more than 20 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Organizer name is too long!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Contributor Validation
            do {
                try {
                    if (request.getParameter("Contributor").equals("")) { //Check empty contributor
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Contributor cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("Contributor").length() > 20) { // cannot have more than 20 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Contributor name is too long!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Skills Validation
            do {
                try {
                    if (request.getParameter("SkillsGained").equals("")) { //Check empty skills
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Skills Gained cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("SkillsGained").length() > 255) { // cannot have more than 255 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Too many skills gained!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Modules Validation
            do {
                try {
                    if (request.getParameter("Modules").equals("")) { //Check empty modules
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Modules cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("Modules").length() > 255) { // cannot have more than 255 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Too many skills gained!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Objective Validation
            do {
                try {
                    if (request.getParameter("Objective").equals("")) { //Check empty Objective
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Objective cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("Objective").length() > 255) { // cannot have more than 255 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Objective too long!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

            //Category Validation
            do {
                List<String> categoryList = Arrays.asList("Business", "Design", "Accounting", "Information Technology", "Language");
                try {
                    if (request.getParameter("Category").equals("")) { //Check empty Category
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Category cannot be empty!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else if (request.getParameter("Category").length() > 50) { // cannot have more than 50 words
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Category too long!');");
                            error.println("window.open('productUpdate.html', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }

                    //Check if it falls within the 5 categories
                    for (int i = 0; i < categoryList.size(); ++i) {
                        if (request.getParameter("Category").equals(categoryList.get(i))) {
                            errorExist = false;
                            break;
                        } else {
                            errorExist = true;
                            try (PrintWriter error = response.getWriter()) {
                                error.println("<!DOCTYPE html>");
                                error.println("<html>");
                                error.println("<body>");
                                error.println("<script type=\"text/javascript\">alert('Category must be either Business, Design, Accounting, Information Technology or Language!');");
                                error.println("window.open('productUpdate.html', '_self');");
                                error.println("</script>");
                                error.println("</body>");
                                error.println("</html>");
                            }
                        }
                    }
                } catch (Exception e) { // Catch any other error
                    errorExist = true;
                    e.printStackTrace();
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error Occured!');");
                        error.println("window.open('productUpdate.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } while (errorExist);

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
