package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Customer {

    private int CustID;
    private String CustName;
    private Date CustDOB;
    private String CustAddress;
    private String CustCity;
    private String CustPostcode;
    private String CustIC;
    private String CustEmail;
    private String CustPhoneNumber;
    private String CustPassword;
    private String CustConfirmPassword;

    private static String url = "jdbc:derby://localhost:1527/SmartLearnDB";
    private static String username = "nbuser";
    private static String password = "nbuser";
    private static String tableName = "Customer";

    public Customer() {

    }

    public Customer(int CustID, String CustName, Date CustDOB, String CustAddress, String CustCity, String CustPostcode, String CustIC, String CustEmail, String CustPhoneNumber, String CustPassword, String CustConfirmPassword) {
        this.CustID = CustID;
        this.CustName = CustName;
        this.CustDOB = CustDOB;
        this.CustAddress = CustAddress;
        this.CustCity = CustCity;
        this.CustPostcode = CustPostcode;
        this.CustIC = CustIC;
        this.CustEmail = CustEmail;
        this.CustPhoneNumber = CustPhoneNumber;
        this.CustPassword = CustPassword;
        this.CustConfirmPassword = CustConfirmPassword;
    }

    public int getCustID() {
        return CustID;
    }

    public String getCustName() {
        return CustName;
    }
    
    //Returns Customer Object
    public static Customer SearchCustomer(int id) {

        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName + " WHERE CustId = ?";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);

                //Get ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Customer customer = new Customer(
                                rs.getInt("CustID"),
                                rs.getString("CustName"),
                                rs.getDate("CustDOB"),
                                rs.getString("CustAddress"),
                                rs.getString("CustCity"),
                                rs.getString("CustPostcode"),
                                rs.getString("CustIC"),
                                rs.getString("CustEmail"),
                                rs.getString("CustPhoneNumber"),
                                rs.getString("CustPassword"),
                                rs.getString("CustConfirmPassword")
                        );
                        return customer;
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return null;
    }

}
