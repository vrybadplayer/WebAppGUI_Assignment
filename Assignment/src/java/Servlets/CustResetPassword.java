package Servlets;
import dataAccess.UserDA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CustResetPassword", urlPatterns = {"/CustResetPassword"})
public class CustResetPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and IC number from session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String icNumber = (String) session.getAttribute("icNumber");

        // Retrieve new password from request parameters
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        boolean errorExist = false;

        do {
            if (password.equals("") || confirmPassword.equals("")) { //check if password and confirm password are empty
                errorExist = true;
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Password field could not be empty!');");
                    error.println("window.history.back('CustResetPassword.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}$")) { //check if password matches the format
                errorExist = true;
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('The password should contain at least 12 characters with combination of uppercase letters, lowercase letters, and numbers!');");
                    error.println("window.history.back('CustResetPassword.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (!confirmPassword.equals(password)) { //check if confirm password match with password
                errorExist = true;
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Confirm Password does not match with the password entered!');");
                    error.println("window.history.back('CustResetPassword.jsp', '_self');");
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
            // Update the password in the database
            UserDA userDA = new UserDA();
            boolean passwordUpdated = userDA.updatePassword(username, icNumber, password);

            if (passwordUpdated) {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Password reset successfully. Please login with your new password.');");
                    error.println("window.location.href = 'customerlogin.jsp';");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                session.invalidate();
            } else {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Error! Failed to reset password. Please try again.');");
                    error.println("window.history.back('CustResetPassword.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
