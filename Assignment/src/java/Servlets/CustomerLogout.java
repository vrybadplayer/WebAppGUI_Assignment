package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CustomerLogout", urlPatterns = {"/CustomerLogout"})
public class CustomerLogout extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter error = response.getWriter()) {
            error.println("<!DOCTYPE html>");
            error.println("<html>");
            error.println("<body>");
            error.println("<script type=\"text/javascript\">alert('Account has logout successfully.');");
            error.println("window.location.href = 'customerlogin.jsp';");
            error.println("</script>");
            error.println("</body>");
            error.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
