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

@WebServlet(name = "CustForgotPassword", urlPatterns = {"/CustForgotPassword"})
public class CustForgotPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String icNumber = request.getParameter("icNumber");

        UserDA userDA = new UserDA();
        boolean isValidUser = userDA.validateIC(username, icNumber);

        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("icNumber", icNumber);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Verified User</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Your identity has been verified. Please proceed to the password reset section.');");
                out.println("window.location.href = 'CustResetPassword.jsp';");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Invalid Username or IC number</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Invalid username or IC number. Please try again.');");
                out.println("window.location.href = 'CustForgotPassword.jsp';");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
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
