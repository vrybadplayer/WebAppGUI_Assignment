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
//        //validate id
        do {
            String staffId = request.getParameter("staffId");
            if (staffDA.searchId(Integer.parseInt(staffId))) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('The employee with the entered StaffID already exist!');");
                    error.println("window.open('staffAdd.html', '_self');");
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
            String staffName = request.getParameter("staffName");
            for (int i = 0; i < staffName.length(); i++) {
                if (Character.isDigit(staffName.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff Name could only contain alphabets!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            }
        } while (errorExist);

        //validate ic
        do {
            String staffIc = request.getParameter("staffIc");
            for (int i = 0; i < staffIc.length(); i++) {
                if (Character.isAlphabetic(staffIc.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff IC could only consist of digits!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            }

            if (staffIc.length() != 12) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff IC consists of 12 digits only!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else {
                errorExist = false;
            }

            int year = Integer.parseInt(staffIc.substring(0, 2));
            int month = Integer.parseInt(staffIc.substring(2, 4));
            int day = Integer.parseInt(staffIc.substring(4, 6));
            if (year < 0 || year > 99) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid year on Staff IC!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }

                break;
            } else {
                errorExist = false;
            }

            if (month < 1 || month > 12) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Invalid month on Staff IC!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day < 1 || day > 31) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid day of month on Staff IC!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }

            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day < 1 || day > 30) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid day of month on Staff IC!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            } else if (month == 2) {
                if (day < 1 || day > 29) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Invalid day of month on Staff IC!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate city
        do {
            String staffCity = request.getParameter("staffCity");
            for (int i = 0; i < staffCity.length(); i++) {
                if (Character.isDigit(staffCity.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff's City could only consists of alphabets!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            }
        } while (errorExist);

        //validate email 
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        do {
            String staffEmail = request.getParameter("staffEmail");
            Matcher matcher = pattern.matcher(staffEmail);
            if (!matcher.matches()) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Email with invalid format entered!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            }
        } while (errorExist);

        //validate postcode
        do {
            String staffPostCode = request.getParameter("staffPostcode");
            for (int i = 0; i < staffPostCode.length(); i++) {
                if (Character.isAlphabetic(staffPostCode.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Postcode only consists of digits!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            }

            if (staffPostCode.length() != 5) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Postcode consists of only 5 digits!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate dob
        do {
            String staffDOB = request.getParameter("staffDOB");
            int year = Integer.parseInt(staffDOB.substring(0, 4));
            int month = Integer.parseInt(staffDOB.substring(5, 7));
            int day = Integer.parseInt(staffDOB.substring(8, 10));
            if (staffDOB.charAt(4) != '-' || staffDOB.charAt(7) != '-') {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB should be in the format of YYYY-MM-DD');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (year < 0 || year < 2003) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB has invalid year');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (month < 1 || month > 12) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB has invalid month!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (month == 1 | month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day < 1 || day > 31) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('DOB has invalid day on month!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }

                    break;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day < 1 || day > 30) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('DOB has invalid day on month!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            } else if (month == 2) {
                if (day < 1 || day > 29) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('DOB has invalid day on month!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                }
            } else {
                errorExist = false;
            }

            //validate with ic
            String icYear = request.getParameter("staffIc").substring(0, 2);
            String icMonth = request.getParameter("staffIc").substring(2, 4);
            String icDay = request.getParameter("staffIc").substring(4, 6);
            String dobYear = request.getParameter("staffDOB").substring(2, 4);
            String dobMonth = request.getParameter("staffDOB").substring(5, 7);
            String dobDay = request.getParameter("staffDOB").substring(8, 10);
            if (!icYear.equals(dobYear) || !icMonth.equals(dobMonth) || !icDay.equals(dobDay)) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('DOB value does not match with DOB on IC!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            }else{
                errorExist = false;
            }
        } while (errorExist);

        //validate tel no
        do {
            String staffPhone = request.getParameter("staffPhone");
            for (int i = 0; i < staffPhone.length(); i++) {
                if (Character.isAlphabetic(staffPhone.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Phone Number could only consists of digits!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;

                }
            }
            if (staffPhone.length() != 10 || staffPhone.length() != 11) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Phone Number only consists of 5 digits!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //validate password
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        do {
            String staffPassword = request.getParameter("staffPassword");
            String staffConfirmPassword = request.getParameter("staffConfirmPassword");
            Matcher matcher = passwordPattern.matcher(staffPassword);
            if (!matcher.matches()) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Password must consist of at least 8 characters with 1 capital letter and 1 digit!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else if (!staffPassword.equals(staffConfirmPassword)) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Passwords do not match!');");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }

                break;
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //role
        do {
            String staffRole = request.getParameter("staffRole");
            for (int i = 0; i < staffRole.length(); i++) {
                if (Character.isDigit(staffRole.charAt(i))) {
                    errorExist = true;
                    try (PrintWriter error = response.getWriter()) {
                        error.println("<!DOCTYPE html>");
                        error.println("<html>");
                        error.println("<body>");
                        error.println("<script type=\"text/javascript\">alert('Staff Roles could only consist of alphabets!');");
                        error.println("window.open('staffAdd.html', '_self');");
                        error.println("</script>");
                        error.println("</body>");
                        error.println("</html>");
                    }
                    break;
                } else {
                    errorExist = false;
                }
            }

            if (!staffRole.equals("Admin") || !staffRole.equals("Manager") || !staffRole.equals("Staff")) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Please enter 'Admin', 'Manager', 'Staff' only!);");
                    error.println("window.open('staffAdd.html', '_self');");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
                break;
            } else {
                errorExist = false;
            }
        } while (errorExist);

        //get all correct details
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        String staffDOB = request.getParameter("staffDOB");
        String staffAddress = request.getParameter("addressLine1") + request.getParameter("addressLine2") + request.getParameter("addressLine3");
        String staffCity = request.getParameter("staffCity");
        String staffIc = request.getParameter("staffIc");
        String staffPostcode = request.getParameter("staffPostcode");
        String staffEmail = request.getParameter("staffEmail");
        String staffPhone = request.getParameter("staffPhone");
        String staffPassword = request.getParameter("staffPassword");
        String staffConfirmPassword = request.getParameter("staffConfirmPassword");
        String staffRole = request.getParameter("staffRole");
        //add to database
        staffDA.addRecord(Integer.parseInt(staffId), staffName, staffDOB, staffAddress, staffCity, staffPostcode, staffIc, staffEmail, staffPhone, staffPassword, staffConfirmPassword, staffRole);

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
            out.println("window.open('staffAdd.html', '_self');");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
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
