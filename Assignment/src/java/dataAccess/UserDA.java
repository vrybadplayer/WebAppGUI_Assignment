package dataAccess;

import domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserDA {

    private String host = "jdbc:derby://localhost:1527/SmartLearnDB";
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

            if (user.getDob() != null) {
                java.sql.Date sqlDate = new java.sql.Date(user.getDob().getTime()); // Convert java.util.Date to java.sql.Date
                stmt.setDate(3, sqlDate);
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }

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

    public boolean validateUser(String username, String password) {
        try {
            String query = "SELECT * FROM " + tableName + " WHERE CustUserName = ? AND CustPassword = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean validateIC(String username, String icNumber) {
        try {
            String query = "SELECT * FROM " + tableName + " WHERE CustUserName = ? AND CustIC = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, icNumber);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCustIDByUsername(String username) {
        int custID = -1; // Default value in case the username is not found
        try {
            String query = "SELECT CustID FROM " + tableName + " WHERE CustUserName = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                custID = rs.getInt("CustID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return custID;
    }

    public boolean updatePassword(String username, String icNumber, String newPassword) {
        boolean passwordUpdated = false;
        try {
            String updateStr = "UPDATE " + tableName + " SET CustPassword = ? WHERE CustUserName = ? AND CustIC = ?";

            // Create PreparedStatement and set parameters
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);
            stmt.setString(3, icNumber);

            // Execute the update query
            int rowsUpdated = stmt.executeUpdate();

            // Check if the password was successfully updated
            if (rowsUpdated > 0) {
                passwordUpdated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle database errors
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return passwordUpdated;
    }

}
