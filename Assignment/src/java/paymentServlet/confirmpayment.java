package paymentServlet;

import dataAccess.PaymentDA;
import domain.payment;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "confirmpayment", urlPatterns = {"/confirmpayment"})
public class confirmpayment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute("CustID");
        BigDecimal totalAmount = (BigDecimal) session.getAttribute("totalAmount");
        BigDecimal discount = (BigDecimal) session.getAttribute("discount");
        String paymentMode = (String) session.getAttribute("paymethod");
        Date paymentDate = null;

        int paymentId = generatePaymentId();

        // Create Payment object
        payment payment = new payment(paymentId, customerId, totalAmount, paymentDate, paymentMode, discount);

        // Store payment information into the database
        PaymentDA paymentDA = new PaymentDA((Connection) getServletContext().getAttribute("connection"));
        boolean paymentStored = paymentDA.storePayment(payment);

        if (paymentStored) {
            // Redirect to a payment confirmation page
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Payment successfully!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script type=\"text/javascript\">alert('Payment successfully!');");
                out.println("window.location.href = '#';"); //Melinda, please add the link to receipt at #//
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Handle the case where payment storage fails
            response.setContentType("text/html");
            response.getWriter().println("Error occurred while processing payment.");
            response.sendRedirect("confirmpayment.jsp");
        }
    }

    private int generatePaymentId() {
        return (int) (Math.random() * 1000);
    }
}
