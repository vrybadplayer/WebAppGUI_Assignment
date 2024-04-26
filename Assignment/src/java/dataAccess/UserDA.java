package dataAccess;

import domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserDA {

    private String host = "jdbc:derby://localhost:1527/SmartLearn";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Customer";
    private Connection conn;
    private PreparedStatement stmt;

    public UserDA() {
        createConnection();
        System.out.println("Connection Established!");
    }

    private void createConnection() {
        try {
            // Load the Derby JDBC driver and establish connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            // Handle any exceptions related to connection setup
            ex.printStackTrace();
        }
    }

    // Method to shutdown the database connection
    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void addUser(User user) {
        try {
            // SQL statement to insert a new user into the User table
            String insertStr = "INSERT INTO " + tableName + " (CustID, CustName, CustDOB, CustAddress, CustCity, CustPostcode, CustIC, CustEmail, CustPhoneNumber, CustUserName, CustPassword) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Create PreparedStatement and set parameters
            stmt = conn.prepareStatement(insertStr);
            stmt.setInt(1, user.getCustID());
            stmt.setString(2, user.getFullName());            
            
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(user.getDob().getTime());
            stmt.setDate(3, sqlDate);
            
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getCity());
            stmt.setString(6, user.getPostcode());
            stmt.setString(7, user.getIcNumber());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getPhoneNumber());
            stmt.setString(10, user.getUsername());
            stmt.setString(11, user.getPassword());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
