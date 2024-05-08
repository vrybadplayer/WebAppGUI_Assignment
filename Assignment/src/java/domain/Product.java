package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

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
    private int reviews;

    //Products Constructor
    public Product() {

    }

    public Product(int id, String name, double price, String synopsis, int duration, String level, String organizer, String contributor, String skills, String modules, String objective, String category, double rating, int reviews) {
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
        this.reviews = reviews;
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

    public double getReviews() {
        return reviews;
    }

    public static void deleteRecord(int prodID) {

        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM " + tableName + " WHERE ProdID = ?";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, prodID);

                stmt.executeQuery();

            }
        } catch (SQLException ex) {

        }
    }

    //Return the ID of the last Product
    public static int NextProductID() {

        ArrayList<Product> productList = new ArrayList<>();
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName;

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

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
                                rs.getDouble("Rating"),
                                rs.getInt("Reviews")
                        );
                        productList.add(product);
                    }
                }
            }
            return productList.get(productList.size() - 1).getId() + 1;
        } catch (SQLException ex) {
            return 0;
        }
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
                                rs.getDouble("Rating"),
                                rs.getInt("Reviews")
                        );
                        return product;
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    //Returns Product List
    public static ArrayList<Product> SearchCategory(String category) {
        ArrayList<Product> productList = new ArrayList<>();
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName + " WHERE Category = ?";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, category);

                //Get ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
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
                                rs.getDouble("Rating"),
                                rs.getInt("Reviews")
                        );

                        productList.add(product);
                    }
                }
            }

            return productList;

        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception properly in your application
        }
        return null;
    }

    public static ArrayList<Product> SearchAll() {
        ArrayList<Product> productList = new ArrayList<>();
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName;

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                //Get ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
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
                                rs.getDouble("Rating"),
                                rs.getInt("Reviews")
                        );

                        productList.add(product);
                    }
                }
            }

            return productList;

        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception properly in your application
        }
        return null;
    }

    public static ArrayList<Product> SearchLike(String input) {

        ArrayList<Product> productList = new ArrayList<>();
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName + " WHERE CourseName LIKE ?";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "%" + input + "%");

                //Get ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
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
                                rs.getDouble("Rating"),
                                rs.getInt("Reviews")
                        );

                        productList.add(product);
                    }
                }
            }

            return productList;

        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception properly in your application
        }
        return null;
    }

    public static void UpdateProduct(int prodID, String courseName, String synopsis, double price, int duration, String experienceLevel, String organizer, String contributor, String skillsGained,
            String modules, String objective, String category) {
        Product prod = Product.SearchProduct(prodID);
        //Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE Product SET CourseName = ?, Synopsis = ?, Price = ?, Duration = ?, Experience_Level = ?, Organizer = ?, Contributor = ?, Skills_Gained = ?, Modules = ?, Objective = ?, Category = ?, Rating = " + prod.getRating() + ", Reviews = " + prod.getReviews() + " WHERE ProdID = ?;";

            //Prepare SQL Statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, courseName);
                stmt.setString(2, synopsis);
                stmt.setDouble(3, price);
                stmt.setInt(4, duration);
                stmt.setString(5, experienceLevel);
                stmt.setString(6, organizer);
                stmt.setString(7, contributor);
                stmt.setString(8, skillsGained);
                stmt.setString(9, modules);
                stmt.setString(10, objective);
                stmt.setString(11, category);
                stmt.setInt(12, prodID);

                //Execute statement
                stmt.executeUpdate();

            }
        } catch (SQLException ex) {
        }
    }

    public static void AddProduct(String courseName, String synopsis, double price, int duration, String experienceLevel,
            String organizer, String contributor, String skillsGained, String modules, String objective, String category) {

        // Generate random rating between 0.0 and 5.0
        double rating = new Random().nextDouble() * 5.0;

        // Generate random reviews between 0 and 150
        int reviews = new Random().nextInt(151);

        // Connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepare SQL statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, Product.NextProductID());
                stmt.setString(2, courseName);
                stmt.setString(3, synopsis);
                stmt.setDouble(4, price);
                stmt.setInt(5, duration);
                stmt.setString(6, experienceLevel);
                stmt.setString(7, organizer);
                stmt.setString(8, contributor);
                stmt.setString(9, skillsGained);
                stmt.setString(10, modules);
                stmt.setString(11, objective);
                stmt.setString(12, category);
                stmt.setDouble(13, rating);
                stmt.setInt(14, reviews);

                stmt.executeUpdate();
            }
        } catch (SQLException ex) {

        }
    }

}
