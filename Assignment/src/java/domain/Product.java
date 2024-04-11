package domain;

import java.sql.*;
import javax.swing.JOptionPane;

public class Product {

    private static String url = "jdbc:derby://localhost:1527/SmartLearnDB";
    private static String username = "nbuser";
    private static String password = "nbuser";
    private static String tableName = "Product";

    private int id;
    private String name;
    private double price;
    private String synopsis;
    private int duration;
    private String level;
    private String organizer;
    private String contributor;
    private String skills;
    private String modules;
    private String objective;
    private String category;
    private double rating;

    //Products Constructor
    public Product() {
        
    }
    
    public Product(int id, String name, double price, String synopsis, int duration, String level, String organizer, String contributor, String skills, String modules, String objective, String category, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.synopsis = synopsis;
        this.duration = duration;
        this.level = level;
        this.organizer = organizer;
        this.contributor = contributor;
        this.skills = skills;
        this.modules = modules;
        this.objective = objective;
        this.category = category;
        this.rating = rating;
    }

    public int getId() {
        return this.id;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public static String getPassword() {
        return password;
    }

    public static String getTableName() {
        return tableName;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String getLevel() {
        return level;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getContributor() {
        return contributor;
    }

    public String getSkills() {
        return skills;
    }

    public String getModules() {
        return modules;
    }

    public String getObjective() {
        return objective;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public void printSkills(int input) {
        System.out.println("test");
    }
    
    //Returns Product Object
    public static Product SearchProduct(int prodID) {

        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName + " WHERE ProdID = ?";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, prodID);

                //Get ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Product product = new Product(
                                rs.getInt("ProdID"),
                                rs.getString("CourseName"),
                                rs.getDouble("Price"),
                                rs.getString("Synopsis"),
                                rs.getInt("Duration"),
                                rs.getString("Experience_Level"),
                                rs.getString("Organizer"),
                                rs.getString("Contributor"),
                                rs.getString("Skills_Gained"),
                                rs.getString("Modules"),
                                rs.getString("Objective"),
                                rs.getString("Category"),
                                rs.getDouble("Rating")
                        );
                        return product;
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Error", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Product Does Not Exist", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }

}
