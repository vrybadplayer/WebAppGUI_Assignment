package dataAccess;

import domain.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDA {
    private String host = "jdbc:derby://localhost:1527/assignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Customer";
    private Connection conn;
    private PreparedStatement stmt;

    public UserDA() {
        createConnection();
    }

    public void addUser(User user) {
        try {
            // SQL statement to insert a new user into the User table
            String insertStr = "INSERT INTO " + tableName + " (CustName, CustDOB, CustAddress, CustCity, CustPostcode, CustIC, CustEmail, CustPhoneNumber, CustUserName, CustPassword) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Create PreparedStatement and set parameters
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, user.getFullName());
            stmt.setDate(2, (Date) user.getDob());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getCity());
            stmt.setString(5, user.getPostcode());
            stmt.setString(6, user.getIcNumber());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getPhoneNumber());
            stmt.setString(9, user.getUsername());
            stmt.setString(10, user.getPassword());
            
            // Execute the update
            stmt.executeUpdate();
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            ex.printStackTrace();
        } finally {
            // Close the PreparedStatement in a finally block to ensure it is always closed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
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
                // Handle any SQL exceptions
                ex.printStackTrace();
            }
        }
    }
}
