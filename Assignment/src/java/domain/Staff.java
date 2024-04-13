/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author sumsn
 */
public class Staff {
    private int StaffID;
    private String StaffName;
    private String StaffDOB;
    private String StaffAddress;
    private String StaffCity;
    private String StaffPostcode;
    private String StaffIC;
    private String StaffEmail;
    private String StaffPhoneNumber;
    private String StaffPassword;
    private String StaffConfirmPassword;
    private String Role;

    public Staff() {
    }

    public Staff(int StaffID, String StaffName, String StaffDOB, String StaffAddress, String StaffCity, String StaffPostcode, String StaffIC, String StaffEmail, String StaffPhoneNumber, String StaffPassword, String StaffConfirmPassword, String Role) {
        this.StaffID = StaffID;
        this.StaffName = StaffName;
        this.StaffDOB = StaffDOB;
        this.StaffAddress = StaffAddress;
        this.StaffCity = StaffCity;
        this.StaffPostcode = StaffPostcode;
        this.StaffIC = StaffIC;
        this.StaffEmail = StaffEmail;
        this.StaffPhoneNumber = StaffPhoneNumber;
        this.StaffPassword = StaffPassword;
        this.StaffConfirmPassword = StaffConfirmPassword;
        this.Role = Role;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public String getStaffDOB() {
        return StaffDOB;
    }

    public void setStaffDOB(String StaffDOB) {
        this.StaffDOB = StaffDOB;
    }

    public String getStaffAddress() {
        return StaffAddress;
    }

    public void setStaffAddress(String StaffAddress) {
        this.StaffAddress = StaffAddress;
    }

    public String getStaffCity() {
        return StaffCity;
    }

    public void setStaffCity(String StaffCity) {
        this.StaffCity = StaffCity;
    }

    public String getStaffPostcode() {
        return StaffPostcode;
    }

    public void setStaffPostcode(String StaffPostcode) {
        this.StaffPostcode = StaffPostcode;
    }

    public String getStaffIC() {
        return StaffIC;
    }

    public void setStaffIC(String StaffIC) {
        this.StaffIC = StaffIC;
    }

    public String getStaffEmail() {
        return StaffEmail;
    }

    public void setStaffEmail(String StaffEmail) {
        this.StaffEmail = StaffEmail;
    }

    public String getStaffPhoneNumber() {
        return StaffPhoneNumber;
    }

    public void setStaffPhoneNumber(String StaffPhoneNumber) {
        this.StaffPhoneNumber = StaffPhoneNumber;
    }

    public String getStaffPassword() {
        return StaffPassword;
    }

    public void setStaffPassword(String StaffPassword) {
        this.StaffPassword = StaffPassword;
    }

    public String getStaffConfirmPassword() {
        return StaffConfirmPassword;
    }

    public void setStaffConfirmPassword(String StaffConfirmPassword) {
        this.StaffConfirmPassword = StaffConfirmPassword;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.StaffID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Staff other = (Staff) obj;
        return this.StaffID == other.StaffID;
    }

    @Override
    public String toString() {
        return "Staff{" + "StaffID=" + StaffID + ", StaffName=" + StaffName + ", StaffDOB=" + StaffDOB + ", StaffAddress=" + StaffAddress + ", StaffCity=" + StaffCity + ", StaffPostcode=" + StaffPostcode + ", StaffIC=" + StaffIC + ", StaffEmail=" + StaffEmail + ", StaffPhoneNumber=" + StaffPhoneNumber + ", StaffPassword=" + StaffPassword + ", StaffConfirmPassword=" + StaffConfirmPassword + ", Role=" + Role + '}';
    }
    
    
           
}
