/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;
import domain.Staff;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author sumsn
 */
public class StaffDA {
    private Connection conn;
    private PreparedStatement stmt;
    private String host = "jdbc:derby://localhost:1527/CourseDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName ="Staff";
    
    public StaffDA(){
        createConnection();
        System.out.println("Connection Established!");
    }
    
    private void createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host,user,password);
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void shutDown(){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void addRecord(int id, String name, String dob, String address, String city, String postcode, String ic, String email, String phoneNumber, String password, String confirmPassword, String role){
        try{
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
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean searchId (int id){
        try{
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE STAFFID = ?");
            stmt.setString(1, Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int databaseStaffId = rs.getInt("StaffID");
                if(id == databaseStaffId){
                    return true;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
