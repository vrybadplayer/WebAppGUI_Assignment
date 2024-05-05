/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package staffServlets;

import dataAccess.StaffDA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sumsn
 */
@WebServlet(name = "StaffChangeUserPassword", urlPatterns = {"/StaffChangeUserPassword"})
public class StaffChangeUserPassword extends HttpServlet {

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
        //get new staff credentials
        String staffId = request.getParameter("staffid");
        String newStaffUsername = request.getParameter("newStaffUsername");
        String newStaffPassword = request.getParameter("newStaffPassword");
        String newStaffConfirmPassword = request.getParameter("newStaffConfirmPassword");

        StaffDA staffDA = new StaffDA();
        boolean errorExist = false;

        //validate staff id
        do {
            try {
                if (!staffDA.searchId(Integer.parseInt(staffId))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff\\'s ID does not exist!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } catch (NumberFormatException ex) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff\\'s ID could only have digits!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        //validate username
        do {
            if (newStaffUsername.equals("")) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff\\'s Username could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
            for (int i = 0; i < newStaffUsername.length(); i++) {
                if (Character.isDigit(newStaffUsername.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff\\'s Username could not have digits!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else {
                    errorExist = false;
                }
            }
        } while (errorExist);

        //validate password
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$"; //1 capital letter, 1 digit, total 8 characters
        Pattern passwordPattern = Pattern.compile(passwordRegex);

        do {
            Matcher matcher = passwordPattern.matcher(newStaffPassword);
            if (newStaffPassword.equals("") || newStaffConfirmPassword.equals("")) { //check if password inputs are empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Password could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!matcher.matches()) { //check if first password matches format
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Password must consist of at least 8 characters with 1 capital letter and 1 digit!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (!newStaffPassword.equals(newStaffConfirmPassword)) { //check if both passwords match
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Passwords do not match!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else {
                errorExist = false;
            }
        } while (errorExist);

        if (!errorExist) {
            staffDA.updateCredentials(Integer.parseInt(staffId), newStaffUsername, newStaffPassword);
            try (PrintWriter error = response.getWriter()) {
                error.println("<!DOCTYPE html>");
                error.println("<html>");
                error.println("<body>");
                error.println("<script type=\"text/javascript\">alert('Credentials updated successfully!');");
                error.println("window.history.back();");
                error.println("</script>");
                error.println("</body>");
                error.println("</html>");
            }
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
