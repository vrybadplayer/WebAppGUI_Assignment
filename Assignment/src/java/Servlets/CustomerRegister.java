package Servlets;

import da.UserDA;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerRegister extends HttpServlet {
    private UserDA userDA;

    @Override
    public void init() throws ServletException {
        userDA = new UserDA();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Extract form data
        String fullName = request.getParameter("fullName");
        String dobStr = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String icNumber = request.getParameter("icNumber");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postcode");

        // Validate input data
        if (fullName == null || fullName.isEmpty() ||
            dobStr == null || dobStr.isEmpty() ||
            address == null || address.isEmpty() ||
            email == null || email.isEmpty() ||
            phoneNumber == null || phoneNumber.isEmpty() ||
            username == null || username.isEmpty() ||
            password == null || password.isEmpty() ||
            confirmPassword == null || confirmPassword.isEmpty() ||
            icNumber == null || icNumber.isEmpty() ||
            city == null || city.isEmpty() ||
            postcode == null || postcode.isEmpty()) {
            out.println("Please fill in all the fields.");
            return; 
        }

        // Validate email format
        if (!isValidEmail(email)) {
            out.println("Please enter a valid email address.");
            return; 
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            out.println("Passwords do not match.");
            return; 
        }

        // Parse date of birth string into Date object
        Date dob = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dob = dateFormat.parse(dobStr);
        } catch (ParseException ex) {
            out.println("Invalid date format for date of birth.");
            return;
        }

        try {
            User newUser = new User(fullName, dob, address, email, phoneNumber, username, password, icNumber, city, postcode);
            userDA.addUser(newUser);
            out.println("Registration successful. Welcome, " + fullName + "!");
        } catch (Exception ex) {
            out.println("An error occurred during registration: " + ex.getMessage());
        } finally {
            out.close();
        }
    }

    // Validate email format using regular expression
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
