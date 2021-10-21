package com.FackbookPostDemo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST,})
    @JsonBackReference
    private UserRegistrationForm userRegistrationForm;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Like> likes;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    public Post() {
    }

    public Post(int id, String message, UserRegistrationForm userRegistrationForm, List<Like> likes, List<Comment> comments) {
        this.id = id;
        this.message = message;
        this.userRegistrationForm = userRegistrationForm;
        this.likes = likes;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserRegistrationForm getUser() {
        return userRegistrationForm;
    }

    public void setUser(UserRegistrationForm userRegistrationForm) {
        this.userRegistrationForm = userRegistrationForm;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + userRegistrationForm +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
