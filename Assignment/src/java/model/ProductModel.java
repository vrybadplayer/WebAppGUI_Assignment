/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sumsn
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModel.updateProduct", query = "UPDATE Product p SET p.courseName = :courseName, p.synopsis = :synopsis, p.price = :price, "
            + "p.duration = :duration, p.experienceLevel = :experienceLevel, p.organizer = :organizer, "
            + "p.contributor = :contributor, p.skillsGained = :skillsGained, p.modules = :modules, "
            + "p.objective = :objective, p.category = :category"
            + "WHERE p.prodId = :prodId"
    ),
    @NamedQuery(name = "ProductModel.insertProduct", query = "INSERT INTO Product VALUES "
            + "(:prodId, :courseName, :synopsis, :price, :duration, :experienceLevel, :organizer, :contributor, :skillsGained, :modules, :objective, :category, :rating, :reviews)"
    ),
    @NamedQuery(name = "ProductModel.deleteProduct", query = "DELETE FROM Product p WHERE p.prodId = :prodId")
})

public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdID")
    private int ProdID;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CourseName")
    private String CourseName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Synopsis")
    private String Synopsis;

    @Column(name = "Price")
    private double Price;

    @Column(name = "Duration")
    private int Duration;

    @Size(min = 1, max = 255)
    @Column(name = "Experience_Level")
    private String Experience_Level;

    @Size(min = 1, max = 255)
    @Column(name = "Organizer")
    private String Organizer;

    @Size(min = 1, max = 255)
    @Column(name = "Contributor")
    private String Contributor;

    @Size(min = 1, max = 255)
    @Column(name = "Modules")
    private String Modules;

    @Size(min = 1, max = 255)
    @Column(name = "Objective")
    private String Objective;

    @Size(min = 1, max = 50)
    @Column(name = "Category")
    private String Category;

    @Column(name = "Rating")
    private double Rating;

    @Column(name = "Reviews")
    private int Reviews;

    public ProductModel() {

    }

    public ProductModel(int ProdID, String CourseName, String Synopsis, double Price, int Duration, String Experience_Level, String Organizer, String Contributor, String Modules, String Objective, String Category, double Rating, int Reviews) {
        this.ProdID = ProdID;
        this.CourseName = CourseName;
        this.Synopsis = Synopsis;
        this.Price = Price;
        this.Duration = Duration;
        this.Experience_Level = Experience_Level;
        this.Organizer = Organizer;
        this.Contributor = Contributor;
        this.Modules = Modules;
        this.Objective = Objective;
        this.Category = Category;
        this.Rating = Rating;
        this.Reviews = Reviews;
    }

}
