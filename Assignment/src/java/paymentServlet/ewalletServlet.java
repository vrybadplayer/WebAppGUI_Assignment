package paymentServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ewalletServlet", urlPatterns = {"/ewalletServlet"})
public class ewalletServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String ewalletType = request.getParameter("ewalletType");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        // Perform validation
        if (!validateEWalletDetails(ewalletType, username, email, phoneNumber, response)) {
            return; 
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("paymethod", ewalletType);

        // Redirect to confirmation page
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Card info verified!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">alert('Card information verified successfully!');");
            out.println("window.location.href = 'confirmpayment.jsp';");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    private boolean validateEWalletDetails(String ewalletType, String username, String email, String phoneNumber, HttpServletResponse response) throws IOException {
        // Perform your validation here based on the specific requirements for E-Wallet details

        if (username == null || username.trim().isEmpty() || ewalletType == null || email == null || phoneNumber == null) {
            sendError(response, "Error: Please fill in all the field.");
            return false;
        }

        if (email.equals("")) { //check if email is empty            
            sendError(response, "Error: Please fill in your email address.");
            return false;
        }

        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            sendError(response, "Email with invalid format entered! Please enter an email address in format: yourname@example.com!");
            return false;
        }

        if (phoneNumber.equals("")) {
            sendError(response, "Phone Number field could not be empty!");
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (Character.isAlphabetic(phoneNumber.charAt(i))) {
                sendError(response, "Phone Number could only consists digits!");
                return false;
            }
        }

        if (phoneNumber.length() != 10 && phoneNumber.length() != 11) {
            sendError(response, "Phone Number only consists of 10 or 11 digits!");
            return false;
        }

        return true; 
    }

    private void sendError(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error</title>");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + errorMessage + "');");
        out.println("window.history.back();");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
    }
}
