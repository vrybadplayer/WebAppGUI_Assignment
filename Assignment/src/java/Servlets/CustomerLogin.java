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

@WebServlet(name = "CustomerLogin", urlPatterns = {"/CustomerLogin"})
public class CustomerLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDA userDA = new UserDA();

        boolean isValidUser = userDA.validateUser(username, password);

        if (isValidUser) {
            int custID = userDA.getCustIDByUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("custID", custID);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login successfully!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Login successful!');");
                out.println("window.location.href = 'index.html';");
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
                out.println("<title>Login Unsuccessfully!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Error! Invalid Username or Password!');");
                out.println("window.location.href = 'customerlogin.jsp';");
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
