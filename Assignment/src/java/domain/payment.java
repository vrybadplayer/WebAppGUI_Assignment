package domain;
import java.math.BigDecimal;
import java.util.Date;

public class payment {
    private int paymentId;
    private int customerId;
    private BigDecimal totalAmount;
    private Date paymentDate;
    private String paymentMode;
    private BigDecimal discount;

    // Constructor
    public payment(int paymentId, int customerId, BigDecimal totalAmount, Date paymentDate, String paymentMode,
            BigDecimal discount) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.discount = discount;
    }

    // Getters and setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", customerId=" + customerId + ", totalAmount=" + totalAmount
                + ", paymentDate=" + paymentDate + ", paymentMode=" + paymentMode + ", discount=" + discount + "]";
    }
}
