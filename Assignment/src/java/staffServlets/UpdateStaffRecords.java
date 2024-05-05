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
@WebServlet(name = "UpdateStaffRecords", urlPatterns = {"/UpdateStaffRecords"})
public class UpdateStaffRecords extends HttpServlet {

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
        boolean errorExist = false;
        StaffDA staffDA = new StaffDA();
        //get all the correct data
        String staffAddress = request.getParameter("addressLine1") + request.getParameter("addressLine2") + request.getParameter("addressLine3");
        String staffCity = request.getParameter("staffCity");
        String staffPostcode = request.getParameter("staffPostcode");
        String staffEmail = request.getParameter("staffEmail");
        String staffPhone = request.getParameter("staffPhone");
        String staffRole = request.getParameter("staffRole");

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
            } else if (staffDA.checkExistingEmail(staffEmail)) {
                errorExist = true;
                try (PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html>");
                    error.println("<html>");
                    error.println("<body>");
                    error.println("<script type=\"text/javascript\">alert('Staff Account with registered email already exist!');");
                    error.println("window.history.back();");
                    error.println("</script>");
                    error.println("</body>");
                    error.println("</html>");
                }
            } else {
                errorExist = false;
            }
        } while (errorExist);

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
            if (staffPostcode.equals("")) { //assuming postcode is empty
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
            } else if (staffPostcode.length() != 5) { // assuming postcode does not have 5 characters
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
                for (int i = 0; i < staffPostcode.length(); i++) {
                    if (Character.isAlphabetic(staffPostcode.charAt(i))) {
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

        if (!errorExist) {
            //get the id from the form first (set and unchanged)
            String staffid = request.getParameter("staffId");
            int id = Integer.parseInt(staffid);
            staffDA.updateRecord(id, staffAddress, staffCity, staffPostcode, staffEmail, staffPhone, staffRole);

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet UpdateStaffRecords</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Data Updated Successfully!');");
                out.println("window.history.back();");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
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
