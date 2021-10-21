package com.FackbookPostDemo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
public class UserRegistrationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Email
    @UniqueElements
    private String email;
    private String area;
    private String address;
    private Date dob;
    private int phone;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;


    public UserRegistrationForm() {
    }

    public UserRegistrationForm(int id, String name, String email, String area, String address, Date dob, int phone, String password, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.area = area;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.password = password;
        this.posts = posts;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
                ", posts=" + posts +
                '}';
    }
}
