package com.fernando.connecto.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String description;
    @NotEmpty @NotNull
    private String image;

    private Date date = new java.sql.Date(System.currentTimeMillis());
    @NotNull
    private boolean offering;
    @JsonIgnoreProperties(value = "post")
    @NotNull @ManyToOne
    private Category category;
    @JsonIgnoreProperties(value = "post")
    @NotNull @ManyToOne
    private User user;

    public Post() {
    }

    public Post(long id, String description, String image, Date date, boolean offering, Category category, User user) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.date = date;
        this.offering = offering;
        this.category = category;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isOffering() {
        return offering;
    }

    public void setOffering(boolean offering) {
        this.offering = offering;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
