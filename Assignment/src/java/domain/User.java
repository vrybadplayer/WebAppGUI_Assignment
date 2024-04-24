// User.java

package domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String fullName;
    private Date dob;
    private String address;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String icNumber;
    private String city;
    private String postcode;

    public User() {
    }

    public User(String fullName, Date dob, String address, String email, String phoneNumber,
            String username, String password, String icNumber, String city, String postcode) {
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.icNumber = icNumber;
        this.city = city;
        this.postcode = postcode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "User{"
                + "fullName='" + fullName + '\''
                + ", dob=" + dob
                + ", address='" + address + '\''
                + ", email='" + email + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + ", icNumber='" + icNumber + '\''
                + ", city='" + city + '\''
                + ", postcode='" + postcode + '\''
                + '}';
    }
}
