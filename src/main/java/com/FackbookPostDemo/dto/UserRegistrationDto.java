package com.FackbookPostDemo.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class UserRegistrationDto {

    private int id;
    private String name;
    private String email;
    private String area;
    private String address;
    private String dob;
    private int phone;
    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(int id, String name, String email, String area, String address, String  dob, int phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.area = area;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.password = password;
    }

    public UserRegistrationDto(String name, String email, String area, String address, String  dob, int phone, String password) {
        this.name = name;
        this.email = email;
        this.area = area;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String  getDob() {
        return dob;
    }

    public void setDob(String  dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegistrationForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}