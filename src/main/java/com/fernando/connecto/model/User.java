package com.fernando.connecto.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String name;
    private String profilePicture;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String email;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String password;
    private String userType;
    private String about;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> post;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Portfolio> portfolio;

    public User() {
    }

    public User(long id, String name, String profilePicture, String email, String password, String userType, String about, List<Post> post) {
        this.id = id;
        this.name = name;
        this.profilePicture = profilePicture;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.about = about;
        this.post = post;
    }

    public List<Portfolio> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Portfolio> portfolio) {
        this.portfolio = portfolio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Post> getPost() {
        return post;
    }

    public void addPost(Post post) {
        this.post.add(post);
    }
}
