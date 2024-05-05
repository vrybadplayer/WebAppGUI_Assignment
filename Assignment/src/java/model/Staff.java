/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sumsn
 */
@Entity
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffid", query = "SELECT s FROM Staff s WHERE s.staffid = :staffid"),
    @NamedQuery(name = "Staff.findByStaffname", query = "SELECT s FROM Staff s WHERE s.staffname = :staffname"),
    @NamedQuery(name = "Staff.findByStaffdob", query = "SELECT s FROM Staff s WHERE s.staffdob = :staffdob"),
    @NamedQuery(name = "Staff.findByStaffaddress", query = "SELECT s FROM Staff s WHERE s.staffaddress = :staffaddress"),
    @NamedQuery(name = "Staff.findByStaffcity", query = "SELECT s FROM Staff s WHERE s.staffcity = :staffcity"),
    @NamedQuery(name = "Staff.findByStaffpostcode", query = "SELECT s FROM Staff s WHERE s.staffpostcode = :staffpostcode"),
    @NamedQuery(name = "Staff.findByStaffic", query = "SELECT s FROM Staff s WHERE s.staffic = :staffic"),
    @NamedQuery(name = "Staff.findByStaffemail", query = "SELECT s FROM Staff s WHERE s.staffemail = :staffemail"),
    @NamedQuery(name = "Staff.findByStaffphonenumber", query = "SELECT s FROM Staff s WHERE s.staffphonenumber = :staffphonenumber"),
    @NamedQuery(name = "Staff.findByStaffpassword", query = "SELECT s FROM Staff s WHERE s.staffpassword = :staffpassword"),
    @NamedQuery(name = "Staff.findByStaffconfirmpassword", query = "SELECT s FROM Staff s WHERE s.staffconfirmpassword = :staffconfirmpassword"),
    @NamedQuery(name = "Staff.findByRole", query = "SELECT s FROM Staff s WHERE s.role = :role")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STAFFID")
    private Integer staffid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "STAFFNAME")
    private String staffname;
    @Column(name = "STAFFDOB")
    //@Temporal(TemporalType.DATE)
    private String staffdob;
    @Size(max = 255)
    @Column(name = "STAFFADDRESS")
    private String staffaddress;
    @Size(max = 50)
    @Column(name = "STAFFCITY")
    private String staffcity;
    @Size(max = 10)
    @Column(name = "STAFFPOSTCODE")
    private String staffpostcode;
    @Size(max = 12)
    @Column(name = "STAFFIC")
    private String staffic;
    @Size(max = 255)
    @Column(name = "STAFFEMAIL")
    private String staffemail;
    @Size(max = 20)
    @Column(name = "STAFFPHONENUMBER")
    private String staffphonenumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "STAFFPASSWORD")
    private String staffpassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "STAFFCONFIRMPASSWORD")
    private String staffconfirmpassword;
    @Size(max = 50)
    @Column(name = "ROLE")
    private String role;

    public Staff() {
    }

    public Staff(Integer staffid) {
        this.staffid = staffid;
    }

    public Staff(Integer staffid, String staffname, String staffpassword, String staffconfirmpassword) {
        this.staffid = staffid;
        this.staffname = staffname;
        this.staffpassword = staffpassword;
        this.staffconfirmpassword = staffconfirmpassword;
    }
    
        public Staff(int StaffID, String StaffName, String StaffDOB, String StaffAddress, String StaffCity, String StaffPostcode, String StaffIC, String StaffEmail, String StaffPhoneNumber, String StaffPassword, String StaffConfirmPassword, String Role) {
        this.staffid = StaffID;
        this.staffname = StaffName;
        this.staffdob = StaffDOB;
        this.staffaddress = StaffAddress;
        this.staffcity = StaffCity;
        this.staffpostcode = StaffPostcode;
        this.staffic = StaffIC;
        this.staffemail = StaffEmail;
        this.staffphonenumber = StaffPhoneNumber;
        this.staffpassword = StaffPassword;
        this.staffconfirmpassword = StaffConfirmPassword;
        this.role = Role;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffdob() {
        return staffdob;
    }

    public void setStaffdob(String staffdob) {
        this.staffdob = staffdob;
    }

    public String getStaffaddress() {
        return staffaddress;
    }

    public void setStaffaddress(String staffaddress) {
        this.staffaddress = staffaddress;
    }

    public String getStaffcity() {
        return staffcity;
    }

    public void setStaffcity(String staffcity) {
        this.staffcity = staffcity;
    }

    public String getStaffpostcode() {
        return staffpostcode;
    }

    public void setStaffpostcode(String staffpostcode) {
        this.staffpostcode = staffpostcode;
    }

    public String getStaffic() {
        return staffic;
    }

    public void setStaffic(String staffic) {
        this.staffic = staffic;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public String getStaffphonenumber() {
        return staffphonenumber;
    }

    public void setStaffphonenumber(String staffphonenumber) {
        this.staffphonenumber = staffphonenumber;
    }

    public String getStaffpassword() {
        return staffpassword;
    }

    public void setStaffpassword(String staffpassword) {
        this.staffpassword = staffpassword;
    }

    public String getStaffconfirmpassword() {
        return staffconfirmpassword;
    }

    public void setStaffconfirmpassword(String staffconfirmpassword) {
        this.staffconfirmpassword = staffconfirmpassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Staff[ staffid=" + staffid + " ]";
    }
    
}
