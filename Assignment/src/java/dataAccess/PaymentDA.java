package dataAccess;
import domain.payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDA {
    private final Connection connection;

    public PaymentDA(Connection connection) {
        this.connection = connection;
    }

    public boolean storePayment(payment payment) {
        boolean paymentStored = false;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO Payment (PaymentID, CustID, TotalAmount, PaymentDate, PaymentMode, Discount) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, payment.getPaymentId());
            pstmt.setInt(2, payment.getCustomerId());
            pstmt.setBigDecimal(3, payment.getTotalAmount());
            pstmt.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            pstmt.setString(5, payment.getPaymentMode());
            pstmt.setBigDecimal(6, payment.getDiscount());

            // Execute the SQL statement
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                paymentStored = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle or log the exception appropriately
                }
            }
        }

        return paymentStored;
    }
}
