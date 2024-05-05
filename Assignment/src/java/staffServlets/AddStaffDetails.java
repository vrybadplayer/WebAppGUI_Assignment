/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package staffServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataAccess.StaffDA;

/**
 *
 * @author sumsn
 */
@WebServlet(name = "AddStaffDetails", urlPatterns = {"/AddStaffDetails"})
public class AddStaffDetails extends HttpServlet {

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
            out.println("<title>Servlet AddStaffDetails</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStaffDetails at " + request.getContextPath() + "</h1>");
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
        boolean errorExist = false;
        StaffDA staffDA = new StaffDA();
        //get all parameters
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        String staffDOB = request.getParameter("staffDOB");
        String staffAddress = request.getParameter("addressLine1") + request.getParameter("addressLine2") + request.getParameter("addressLine3");
        String staffCity = request.getParameter("staffCity");
        String staffIc = request.getParameter("staffIc");
        String staffPostCode = request.getParameter("staffPostcode");
        String staffEmail = request.getParameter("staffEmail");
        String staffPhone = request.getParameter("staffPhone");
        String staffPassword = request.getParameter("staffPassword");
        String staffConfirmPassword = request.getParameter("staffConfirmPassword");
        String staffRole = request.getParameter("staffRole");

        //validate id
        do {
            try {
                if (staffId.equals("")) { //check for empty staff id
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff ID cannot be empty!');");
                        //error.println("window.open('manager/StaffAdd.jsp', '_self');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else if (staffDA.searchId(Integer.parseInt(staffId))) { //check for duplicate ids
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('The employee with the entered StaffID already exist!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            } catch (NumberFormatException ex) { //if entered alphabets, catch exception
                try (PrintWriter error = response.getWriter()) { //catch exception aassuming user key in characters
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter digits for Staff ID only!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        //validate ic
        do {
            for (int i = 0; i < staffIc.length(); i++) { //check if ic has alphabets
                if (Character.isAlphabetic(staffIc.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff IC could only consist of digits!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            }
            try {
                int year = Integer.parseInt(staffIc.substring(0, 2)); //check the first 6 digits (dob)
                int month = Integer.parseInt(staffIc.substring(2, 4));
                int day = Integer.parseInt(staffIc.substring(4, 6));
                if (staffIc.equals("")) { //check if ic is empty string
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff IC could not be empty!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else if (staffIc.length() != 12) { //check length of ic, must be 12
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff IC consists of 12 digits only!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else if ((year >= 33 && year <= 99) && (year >= 0 && year <= 3)) { //year can only be 1933 - 2003
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid year on Staff IC!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else if (month < 1 || month > 12) { //month can only be 1 - 12
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid month on Staff IC!');");
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day < 1 || day > 31) { //month of 1,3,5,7,8,10,12, has 31 days
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on Staff IC!');");
                            error.println("window.history.back();");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day < 1 || day > 30) { //month of 4,6,9,11, has 30 days
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on Staff IC!');");
                            error.println("window.history.back();");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                    }
                } else if (month == 2) {
                    if (day < 1 || day > 29) { //month of 2 has 29 days
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Invalid day of month on Staff IC!');");
                            error.println("window.history.back();");
                            error.println("</script>");
                            error.println("</body>");
                            error.println("</html>");
                        }
                    }
                } else {
                    errorExist = false;
                }
            } catch (IndexOutOfBoundsException ex) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter 12 digits for Staff IC!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } while (errorExist);

        //validate city
        do {
            if (staffCity.equals("")) { //check if city is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff City could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
            for (int i = 0; i < staffCity.length(); i++) {
                if (Character.isDigit(staffCity.charAt(i))) { //check if city got digits
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff\\'s City could only consists of alphabets!');");
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

        //validate email 
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; //email format
        Pattern pattern = Pattern.compile(emailRegex);
        do {
            Matcher matcher = pattern.matcher(staffEmail);
            if (staffEmail.equals("")) { //check if email is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Email could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!matcher.matches()) { //check if email matches format
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Email with invalid format entered!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);
        
        //check for duplicate records on ic and email together
        do{
            if(staffDA.checkExistingEmail(staffEmail)){
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff account with registered email already exist!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }else if(staffDA.checkExistingIC(staffIc)){
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff account with registered ic already exist!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }else{
                errorExist = false;
            }
        }while(errorExist);

        //validate address
        do {
            if (staffAddress.equals("")) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Address could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate postcode
        do {
            if (staffPostCode.equals("")) { //assuming postcode is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Postcode could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (staffPostCode.length() != 5) { // assuming postcode does not have 5 characters
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Postcode consists of only 5 digits!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                for (int i = 0; i < staffPostCode.length(); i++) {
                    if (Character.isAlphabetic(staffPostCode.charAt(i))) {
                        errorExist = true;
                        try (PrintWriter error = response.getWriter()) {
                            error.println("<!DOCTYPE html>");
                            error.println("<html>");
                            error.println("<body>");
                            error.println("<script type=\"text/javascript\">alert('Postcode only consists of digits!');");
                            error.println("window.history.back();");
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

        //validate dob
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            try {
                year = Integer.parseInt(staffDOB.substring(0, 4)); //extract date from dob
                month = Integer.parseInt(staffDOB.substring(5, 7));
                day = Integer.parseInt(staffDOB.substring(8, 10));
            } catch (NumberFormatException ex) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter digits for DOB only!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            errorExist = true;
            try (PrintWriter error = response.getWriter()) {
                error.println("<!DOCTYPE html>");
                error.println("<html>");
                error.println("<body>");
                error.println("<script type=\"text/javascript\">alert('Please enter 10 characters');");
                error.println("window.history.back();");
                error.println("</script>");
                error.println("</body>");
                error.println("</html>");
            }
        }
        do {
            //validate with ic
            String icYear = staffIc.substring(0, 2);
            String icMonth = staffIc.substring(2, 4);
            String icDay = staffIc.substring(4, 6);
            String dobYear = staffDOB.substring(2, 4);
            String dobMonth = staffDOB.substring(5, 7);
            String dobDay = staffDOB.substring(8, 10);
            if (staffDOB.equals("")) { //check for empty string
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff DOB could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (staffDOB.charAt(4) != '-' || staffDOB.charAt(7) != '-') { //check format for date
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB should be in the format of YYYY-MM-DD');"); //check if date is in correct format
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (year < 1933 || year > 2003) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB has invalid year');"); //check if year is between 1933 - 2003
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (month < 1 || month > 12) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB has invalid month!');"); //check if month is between 1 - 12
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (month == 1 | month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day < 1 || day > 31) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('DOB has invalid day on month!');"); //check if day is between 1 - 31 for following months
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day < 1 || day > 30) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('DOB has invalid day on month!');"); //check if day is between 1 - 30 for following months
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            } else if (month == 2) {
                if (day < 1 || day > 29) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('DOB has invalid day on month!');"); //check if fay exceeds 29 for february
                        error.println("window.history.back();");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                }
            }
            if (!icYear.equals(dobYear) || !icMonth.equals(dobMonth) || !icDay.equals(dobDay)) { //check dob on ic with actual value
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB value does not match with DOB on IC!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate tel no
        do {
            if (staffPhone.equals("")) { //check if tel no is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Phone Number could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (staffPhone.length() != 10 && staffPhone.length() != 11) { //check if phone number has 11 or 10 digits
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Phone Number only consists of 10 or 11 digits!');"); //check length of phoneNumber
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
            for (int i = 0; i < staffPhone.length(); i++) { //check if telephone contains alphabets
                if (Character.isAlphabetic(staffPhone.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Phone Number could only consists of digits!');"); //check for alphabets
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
            Matcher matcher = passwordPattern.matcher(staffPassword);
            if (staffPassword.equals("") || staffConfirmPassword.equals("")) { //check if password inputs are empty
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
            } else if (!staffPassword.equals(staffConfirmPassword)) { //check if both passwords match
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
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate role
        do {
            if (staffRole.equals("")) { //check if role input is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Role could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!staffRole.equals("Admin") && !staffRole.equals("Manager") && !staffRole.equals("Security") && !staffRole.equals("Staff")) { //check for the specific values for role
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter \\'Admin\\', \\'Manager\\', \\'Staff\\', \\'Security\\' only!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate name
        do {
            if (staffName.equals("")) { //check if username is empty
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Username could not be empty!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else if (!staffName.equals(staffId + staffPassword)) { //check if username uses staffid and password combination
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Username is a combination of StaffID and Staff Password!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //get all correct details
        if (!errorExist) {
            //add to database
            staffDA.addRecord(Integer.parseInt(staffId), staffName, staffDOB, staffAddress, staffCity, staffPostCode, staffIc, staffEmail, staffPhone, staffPassword, staffConfirmPassword, staffRole);

            //print successful message window
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Success!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Data added successfully!');");
                out.println("window.history.back();");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }
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
