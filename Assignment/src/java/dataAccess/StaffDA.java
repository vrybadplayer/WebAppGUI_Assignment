/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import com.sun.xml.ws.xmlfilter.Invocation;
import java.io.PrintWriter;
import model.Staff;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import sun.security.rsa.RSACore;

/**
 *
 * @author sumsn
 */
public class StaffDA {

    private Connection conn;
    private PreparedStatement stmt;
    private String host = "jdbc:derby://localhost:1527/SmartLearnDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Staff";

    public StaffDA() {
        createConnection();
        System.out.println("Connection Established!");
    }

    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void addRecord(int id, String name, String dob, String address, String city, String postcode, String ic, String email, String phoneNumber, String password, String confirmPassword, String role) {
        try {
            stmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, Integer.toString(id));
            stmt.setString(2, name);
            stmt.setString(3, dob);
            stmt.setString(4, address);
            stmt.setString(5, city);
            stmt.setString(6, postcode);
            stmt.setString(7, ic);
            stmt.setString(8, email);
            stmt.setString(9, phoneNumber);
            stmt.setString(10, password);
            stmt.setString(11, confirmPassword);
            stmt.setString(12, role);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteRecord(int id){
        try{
            stmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE StaffID = ?");
            stmt.setString(1, Integer.toString(id));
            stmt.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void updateRecord(int id, String address, String city, String postcode, String email, String phoneNumber, String role){
        try{
            stmt = conn.prepareStatement("UPDATE " + tableName + " SET StaffAddress = ?, StaffCity = ?, StaffPostcode = ?, StaffEmail = ?, StaffPhoneNumber = ?, Role = ? WHERE StaffID = ?");
            stmt.setString(1, address);
            stmt.setString(2, city);
            stmt.setString(3, postcode);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, role);
            stmt.setString(7, Integer.toString(id));
            stmt.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public boolean searchId(int id) {
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE STAFFID = ?");
            stmt.setString(1, Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int databaseStaffId = rs.getInt("StaffID");
                if (id == databaseStaffId) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Staff> getRecords(int offset) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();
            rs.absolute(offset);
            for (int i = 0; i < 10; i++) {
                if (rs.next()) {
                    System.out.println(rs.getString("StaffID"));
                    Staff staff = new Staff(Integer.parseInt(rs.getString("StaffID")), rs.getString("StaffName"), rs.getString("StaffDOB"), rs.getString("StaffAddress"), rs.getString("StaffCity"), rs.getString("StaffPostcode"), rs.getString("StaffIC"), rs.getString("StaffEmail"), rs.getString("StaffPhoneNumber"), rs.getString("StaffPassword"), rs.getString("StaffConfirmPassword"), rs.getString("Role"));
                    staffList.add(staff);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return staffList;
    }

    public Staff getIdRecords(int id) {
        Staff staff = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE StaffID = ?");
            stmt.setString(1, Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                staff = new Staff(Integer.parseInt(rs.getString("StaffID")), rs.getString("StaffName"), rs.getString("StaffDOB"), rs.getString("StaffAddress"), rs.getString("StaffCity"), rs.getString("StaffPostcode"), rs.getString("StaffIC"), rs.getString("StaffEmail"), rs.getString("StaffPhoneNumber"), rs.getString("StaffPassword"), rs.getString("StaffConfirmPassword"), rs.getString("Role"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return staff;
    }
    
}
