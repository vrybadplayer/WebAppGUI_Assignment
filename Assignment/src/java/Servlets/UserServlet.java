package Servlets;

import dataAccess.CustomerIDManager;
import dataAccess.UserDA;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet", "/list", "/new", "/insert", "/delete", "/edit", "/update"})
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDA userDA;

    @Override
    public void init() throws ServletException {
        userDA = new UserDA();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;

                case "/insert":
                    insertUser(request, response);
                    break;

                case "/delete":
                    deleteUser(request, response);
                    break;

                case "/edit":
                    showEditForm(request, response);
                    break;

                case "/update":
                    updateUser(request, response);
                    break;

                default:
                    listUser(request, response);
                    break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
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

        boolean errorExist = false;
        // Validate full name format
        do {
            if (fullName.equals("")) { //check for empty customer full name
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Full name cannot be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!fullName.matches("^[a-zA-Z ]+$")) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid full name! Please make sure there are only alphabet in full name!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate date of birth
        Date dob = null;
        do {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dob = dateFormat.parse(dobStr);

                // Calculate age
                Calendar dobCal = Calendar.getInstance();
                dobCal.setTime(dob);
                Calendar minDobCal = Calendar.getInstance();
                minDobCal.add(Calendar.YEAR, -100); // 100 years ago
                Calendar maxDobCal = Calendar.getInstance();
                maxDobCal.add(Calendar.YEAR, 0); // 0 years ago

                if (dobStr.equals("")) { // Check if the date of birth field is empty
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Date of birth cannot be empty!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else if (dobCal.after(maxDobCal) || dobCal.before(minDobCal)) {// Check if the user is below 0 or above 100 years old 
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid Date of Birth. Age must be between 0 and 100 years!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else {
                    errorExist = false;
                }
            } catch (ParseException ex) {
                try (PrintWriter error = response.getWriter()) { //catch exception of invalid date format for date of birth.
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid date format for date of birth!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        // Validate address 
        do {
            if (address.equals("")) { // Check if the address field is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Address field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (address.length() < 5) { // Validate address length
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter a valid address containing State, City, and Postcode!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate email format
        do {
            if (email.equals("")) { //check if email is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Email field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) { //check if email matches format
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Email with invalid format entered! Please enter an email address in format: yourname@example.com!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate phone number format
        do {
            if (phoneNumber.equals("")) { //check if phone no is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Phone Number field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
            for (int i = 0; i < phoneNumber.length(); i++) { //check if phone number contains any alphabets
                if (Character.isAlphabetic(phoneNumber.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Phone Number could only consists digits!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            }

            if (phoneNumber.length() != 10 && phoneNumber.length() != 11) { //check if phone number has 11 or 10 digits
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Phone Number only consists of 10 or 11 digits!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            }
            errorExist = false;
        } while (errorExist);

        // Validate username
        do {
            if (username.equals("")) { //check for empty username
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Username field cannot be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (username.length() > 25) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter username in length less than 25!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate password format
        do {
            if (password.equals("")) { //check if password is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Password field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}$")) { //check if password matches the format
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('The password should contain at least 12 characters with combination of uppercase letters, lowercase letters, and numbers!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            }
            errorExist = false;
        } while (errorExist);

        // Validate IC number format        
        do {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dob = dateFormat.parse(dobStr);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dob);
                int dobYear = calendar.get(Calendar.YEAR);
                int dobMonth = calendar.get(Calendar.MONTH) + 1;
                int dobDay = calendar.get(Calendar.DAY_OF_MONTH);

                for (int i = 0; i < icNumber.length(); i++) {
                    if (Character.isAlphabetic(icNumber.charAt(i))) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('IC number could only consist of digits!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                }

                int icYear = Integer.parseInt(icNumber.substring(0, 2));
                int icMonth = Integer.parseInt(icNumber.substring(2, 4));
                int icDay = Integer.parseInt(icNumber.substring(4, 6));

                if (icNumber.equals("")) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('IC number field could not be empty!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (icNumber.length() != 12) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('IC number must be in length of 12 digits!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if ((icYear >= 33 && icYear <= 99) || (icYear >= 0 && icYear <= 3)) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid year for IC number!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (icMonth < 1 || icMonth > 12) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid month on IC number!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (icMonth == 1 || icMonth == 3 || icMonth == 5 || icMonth == 7 || icMonth == 8 || icMonth == 10 || icMonth == 12) {
                    if (icDay < 1 || icDay > 31) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on IC number!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                } else if (icMonth == 4 || icMonth == 6 || icMonth == 9 || icMonth == 11) {
                    if (icDay < 1 || icDay > 30) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on IC number!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                } else if (icMonth == 2) {
                    if (icDay < 1 || icDay > 29) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on IC number!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                } else if (icDay != dobDay || icMonth != dobMonth || icYear != dobYear) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error! IC number must be compatible with the date of birth selected!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }

            } catch (ParseException ex) {
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid date format for date of birth!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        // Validate city format
        do {
            if (city.equals("")) { //check if city field is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('City field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
            for (int i = 0; i < city.length(); i++) {
                if (Character.isDigit(city.charAt(i))) { //check if city got digits
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('City could only consists of alphabets!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            }
            errorExist = false;
        } while (errorExist);

        // Validate postcode format
        do {
            if (postcode.equals("")) { //check if postcode is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Postcode field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (postcode.length() != 5) { // check postcode length have 5 characters
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Postcode consists of only 5 digits!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                for (int i = 0; i < postcode.length(); i++) {
                    if (Character.isAlphabetic(postcode.charAt(i))) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Postcode only consists of digits!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                }
                errorExist = false;
            }
        } while (errorExist);

        if (!errorExist) {
            if (dobStr != null && !dobStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dob = dateFormat.parse(dobStr);
            } else {
                dob = null;
            }

            int nextCustID = CustomerIDManager.getNextCustomerID();
            User newUser = new User(nextCustID, fullName, dob, address, email, phoneNumber, username, password, icNumber, city, postcode);

            userDA.addUser(newUser);

            try (PrintWriter success = response.getWriter()) {
                success.println("<!DOCTYPE html>");
                success.println("<html>");
                success.println("<body>");
                success.println("<script type=\"text/javascript\">alert('Added successfully!');");
                success.println("window.location.href = 'list';"); // Redirect to list page
                success.println("</script>");
                success.println("</body>");
                success.println("</html>");
            }


        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userDA.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter success = response.getWriter()) {
            success.println("<!DOCTYPE html>");
            success.println("<html>");
            success.println("<body>");
            success.println("<script type=\"text/javascript\">alert('Deleted successfully!');");
            success.println("window.location.href = 'list';"); // Redirect to list page
            success.println("</script>");
            success.println("</body>");
            success.println("</html>");
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        User existingUser;
        try {
            existingUser = userDA.selectUser(id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(existingUser.getDob());
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            request.setAttribute("user", existingUser);
            request.setAttribute("formattedDate", formattedDate);
            dispatcher.forward(request, response);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
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

        boolean errorExist = false;
        // Validate full name format
        do {
            if (fullName.equals("")) { //check for empty customer full name
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Full name cannot be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!fullName.matches("^[a-zA-Z ]+$")) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid full name! Please make sure there are only alphabet in full name!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate date of birth
        Date dob = null;
        do {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dob = dateFormat.parse(dobStr);

                // Calculate age
                Calendar dobCal = Calendar.getInstance();
                dobCal.setTime(dob);
                Calendar minDobCal = Calendar.getInstance();
                minDobCal.add(Calendar.YEAR, -100); // 100 years ago
                Calendar maxDobCal = Calendar.getInstance();
                maxDobCal.add(Calendar.YEAR, 0); // 0 years ago

                if (dobStr.equals("")) { // Check if the date of birth field is empty
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Date of birth cannot be empty!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else if (dobCal.after(maxDobCal) || dobCal.before(minDobCal)) {// Check if the user is below 0 or above 100 years old 
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid Date of Birth. Age must be between 0 and 100 years!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else {
                    errorExist = false;
                }
            } catch (ParseException ex) {
                try (PrintWriter error = response.getWriter()) { //catch exception of invalid date format for date of birth.
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid date format for date of birth!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        // Validate address 
        do {
            if (address.equals("")) { // Check if the address field is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Address field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (address.length() < 5) { // Validate address length
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter a valid address containing State, City, and Postcode!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate email format
        do {
            if (email.equals("")) { //check if email is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Email field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) { //check if email matches format
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Email with invalid format entered! Please enter an email address in format: yourname@example.com!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate phone number format
        do {
            if (phoneNumber.equals("")) { //check if phone no is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Phone Number field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
            for (int i = 0; i < phoneNumber.length(); i++) { //check if phone number contains any alphabets
                if (Character.isAlphabetic(phoneNumber.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Phone Number could only consists digits!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            }

            if (phoneNumber.length() != 10 && phoneNumber.length() != 11) { //check if phone number has 11 or 10 digits
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Phone Number only consists of 10 or 11 digits!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            }
            errorExist = false;
        } while (errorExist);

        // Validate username
        do {
            if (username.equals("")) { //check for empty username
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Username field cannot be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (username.length() > 25) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter username in length less than 25!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        // Validate password format
        do {
            if (password.equals("")) { //check if password is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Password field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}$")) { //check if password matches the format
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('The password should contain at least 12 characters with combination of uppercase letters, lowercase letters, and numbers!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            }
            errorExist = false;
        } while (errorExist);

        // Validate IC number format        
        do {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dob = dateFormat.parse(dobStr);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dob);
                int dobYear = calendar.get(Calendar.YEAR);
                int dobMonth = calendar.get(Calendar.MONTH) + 1;
                int dobDay = calendar.get(Calendar.DAY_OF_MONTH);

                for (int i = 0; i < icNumber.length(); i++) {
                    if (Character.isAlphabetic(icNumber.charAt(i))) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('IC number could only consist of digits!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    } else {
                        errorExist = false;
                    }
                }

                int icYear = Integer.parseInt(icNumber.substring(0, 2));
                int icMonth = Integer.parseInt(icNumber.substring(2, 4));
                int icDay = Integer.parseInt(icNumber.substring(4, 6));

                if (icNumber.equals("")) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('IC number field could not be empty!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (icNumber.length() != 12) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('IC number must be in length of 12 digits!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if ((icYear >= 33 && icYear <= 99) || (icYear >= 0 && icYear <= 3)) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid year for IC number!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (icMonth < 1 || icMonth > 12) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid month on IC number!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (icMonth == 1 || icMonth == 3 || icMonth == 5 || icMonth == 7 || icMonth == 8 || icMonth == 10 || icMonth == 12) {
                    if (icDay < 1 || icDay > 31) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on IC number!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                } else if (icMonth == 4 || icMonth == 6 || icMonth == 9 || icMonth == 11) {
                    if (icDay < 1 || icDay > 30) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on IC number!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                } else if (icMonth == 2) {
                    if (icDay < 1 || icDay > 29) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on IC number!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                } else if (icDay != dobDay || icMonth != dobMonth || icYear != dobYear) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Error! IC number must be compatible with the date of birth selected!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }

            } catch (ParseException ex) {
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid date format for date of birth!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        // Validate city format
        do {
            if (city.equals("")) { //check if city field is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('City field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
            for (int i = 0; i < city.length(); i++) {
                if (Character.isDigit(city.charAt(i))) { //check if city got digits
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('City could only consists of alphabets!');");
                        error.println("window.history.back('customerregister.jsp', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            }
            errorExist = false;
        } while (errorExist);

        // Validate postcode format
        do {
            if (postcode.equals("")) { //check if postcode is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Postcode field could not be empty!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (postcode.length() != 5) { // check postcode length have 5 characters
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Postcode consists of only 5 digits!');");
                    error.println("window.history.back('customerregister.jsp', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                for (int i = 0; i < postcode.length(); i++) {
                    if (Character.isAlphabetic(postcode.charAt(i))) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Postcode only consists of digits!');");
                            error.println("window.history.back('customerregister.jsp', '_self');");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                        break;
                    }
                }
                errorExist = false;
            }
        } while (errorExist);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (dobStr != null && !dobStr.isEmpty()) {
            dob = dateFormat.parse(dobStr);
        } else {
            dob = null;
        }

        User updateUser = new User(id, fullName, dob, address, email, phoneNumber, username, password, icNumber, city, postcode);
        userDA.updateUser(updateUser);

        try (PrintWriter success = response.getWriter()) {
            success.println("<!DOCTYPE html>");
            success.println("<html>");
            success.println("<body>");
            success.println("<script type=\"text/javascript\">alert('Updated successfully!');");
            success.println("window.location.href = 'list';"); // Redirect to list page
            success.println("</script>");
            success.println("</body>");
            success.println("</html>");
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        try {
            List<User> listUser = userDA.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
