package Servlets;

import dataAccess.CustomerIDManager;
import dataAccess.UserDA;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerConfirmation", urlPatterns = {"/CustomerConfirmation"})
public class CustomerConfirmation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        boolean confirmed = Boolean.parseBoolean(request.getParameter("confirmed"));

        if (confirmed) {
            String fullName = (String) request.getParameter("fullName");
            String dobStr = (String) request.getParameter("dob"); // YYYY-MM-DD
            String address = (String) request.getParameter("address");
            String email = (String) request.getParameter("email");
            String phoneNumber = (String) request.getParameter("phoneNumber");
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            String icNumber = (String) request.getParameter("icNumber");
            String city = (String) request.getParameter("city");
            String postcode = (String) request.getParameter("postcode");

            Date dob;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            if (dobStr != null && !dobStr.isEmpty()) {
                dob = dateFormat.parse(dobStr);
            } else {
                dob = null;
            }

            int nextCustID = CustomerIDManager.getNextCustomerID();
            
            UserDA userDA = new UserDA();
            User newUser = new User(nextCustID, fullName, dob, address, email, phoneNumber, username, password, icNumber, city, postcode);
            userDA.addUser(newUser);

            //print successful message window
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Register successfully!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Registered successfully!');");
                out.println("window.location.href = 'index.html';");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }

        } else {
            response.sendRedirect("customerregister.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerConfirmation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
