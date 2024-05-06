/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import domain.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class reviewsDA {

    private int ProdID;
    private String CustName;
    private String Comment;
    private double Rating;

    private static String url = "jdbc:derby://localhost:1527/SmartLearnDB";
    private static String username = "nbuser";
    private static String password = "nbuser";
    private static String tableName = "Review";

    public reviewsDA() {

    }

    public reviewsDA(int ProdID, String CustName, String Comment, double Rating) {
        this.ProdID = ProdID;
        this.CustName = CustName;
        this.Comment = Comment;
        this.Rating = Rating;
    }

    public int getProdID() {
        return ProdID;
    }

    public String getCustName() {
        return CustName;
    }

    public String getComment() {
        return Comment;
    }

    public double getRating() {
        return Rating;
    }

    public void setProdID(int ProdID) {
        this.ProdID = ProdID;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public static void InsertReviews(int ProdID, String CustName, String Comment, double Rating) {
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?)";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, ProdID);
                stmt.setString(2, CustName);
                stmt.setString(3, Comment);
                stmt.setDouble(4, Rating);

                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception properly in your application
        }
    }

    public static ArrayList<reviewsDA> GetReviews(int ProdID) {
        ArrayList<reviewsDA> reviewList = new ArrayList<>();
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName + " WHERE ProdID = ?";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, ProdID);

                //Get ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        reviewsDA review = new reviewsDA(
                                rs.getInt("ProdID"),
                                rs.getString("CustName"),
                                rs.getString("Comment"),
                                rs.getDouble("Rating")
                        );
                        reviewList.add(review);
                    }
                }
            }

            return reviewList;

        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception properly in your application
        }
        return null;
    }

}
