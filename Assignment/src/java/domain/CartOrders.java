/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CartOrders {

    private static String url = "jdbc:derby://localhost:1527/SmartLearnDB";
    private static String username = "nbuser";
    private static String password = "nbuser";
    private static String tableName = "CartOrders";

    private int HKPK;
    private int custId;
    private int prodId;
    private String date;

    public CartOrders() {

    }

    public CartOrders(int hkpk, int custId, int prodId, String date) {
        this.HKPK = hkpk;
        this.custId = custId;
        this.prodId = prodId;
        this.date = date;
    }

    public int getHKPK() {
        return HKPK;
    }

    public int getCustId() {
        return custId;
    }

    public int getProdId() {
        return prodId;
    }

    public String getDate() {
        return date;
    }

    public void setHKPK(int HKPK) {
        this.HKPK = HKPK;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
    //Need to use UTX instead of JDBC
    public static void AddToCart(int hkpk, int cust, int prod, String date) {
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO " + tableName + " VALUES(?,?,?,?)";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, hkpk);
                stmt.setInt(2, cust);
                stmt.setInt(3, prod);
                stmt.setString(4, date);

                //Execute the statement
                stmt.executeUpdate();

                //Close conn and stmt
                stmt.close();
                conn.close();
            }

        } catch (SQLException ex) {

        }
    }

    //Search HKPK for auto increment
    public static int NextHKPK() {

        ArrayList<CartOrders> orderList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        CartOrders cartOrder = new CartOrders(
                                rs.getInt("HKPK"),
                                rs.getInt("CustID"),
                                rs.getInt("ProdID"),
                                rs.getString("CheckoutDate")
                        );
                        orderList.add(cartOrder);
                    }
                }
            }
        } catch (SQLException e) {
        }

        //Get the last HKPK and add 1
        if (orderList.size() == 0) {
            return 1000;
        }
        int nextHKPK = orderList.get(orderList.size() - 1).getHKPK() + 1;
        return nextHKPK;

    }
}
