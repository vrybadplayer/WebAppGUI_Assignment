package paymentServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cardServlet", urlPatterns = {"/cardServlet"})
public class cardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve form data
        String cardType = request.getParameter("cardType");
        String cardName = request.getParameter("cardholderName");
        String cardNumber = request.getParameter("cardNumber");
        String expireDateStr = request.getParameter("expirationDate");
        String cvv = request.getParameter("cvv");

        // Perform validation
        if (!validateInput(cardName, cardNumber, expireDateStr, cvv, response)) {
            return; // Validation failed, error message already sent
        }

        HttpSession session = request.getSession();
        session.setAttribute("paymethod", cardType);
        
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

    private boolean validateInput(String cardName, String cardNumber, String expireDateStr, String cvv, HttpServletResponse response) throws IOException {
        if (cardName == null || cardName.trim().isEmpty()
                || cardNumber == null || cardNumber.trim().isEmpty()
                || expireDateStr == null || expireDateStr.trim().isEmpty()
                || cvv == null || cvv.trim().isEmpty()) {
            sendError(response, "Error: Please fill out all the fields.");
            return false;
        }

        String[] parts = expireDateStr.split("/");
        if (parts.length != 2) {
            sendError(response, "Error: Invalid expiration date format. Example of format: 11/26, where '/' should be located at the third character.");
            return false;
        }

        try {
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            sendError(response, "Error: Invalid expiration date format. Example of format: 11/26 ");
            return false;
        }

        String cardNumberRegex = "^(4[0-9]{15}|5[1-5][0-9]{14})$";
        String expirationRegex = "^((0[1-9])|(1[0-2]))[\\/\\.\\-]*((0[8-9])|(2[1-9]))$";
        String cvvRegex = "^[0-9]{3,4}$";

    if (!cardNumber.matches(cardNumberRegex)) {
        sendError(response, "Error: Please enter a valid card number. For Visa, it should start with 4 and have 16 digits, for Mastercard, it should start with 5 and have 16 digits.");
        return false;
    }

        if (!expireDateStr.matches(expirationRegex)) {
            sendError(response, "Error: Please enter a valid expiration date. Please follow format: MM/YY where MM stand for two-digit month and YY stand for last two-digit of the year.");
            return false;
        }

        if (!cvv.matches(cvvRegex)) {
            sendError(response, "Error: Please enter a valid CVV. CVV must be a three-digit code.");
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
