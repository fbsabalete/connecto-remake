package com.fernando.connecto.model.dto;

import com.fernando.connecto.model.Post;

public class PostDTO {

    private long id;
    private String description;
    private String image;
    private String date;
    private boolean offering;
    private long userId;
    private long categoryId;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.description = post.getDescription();
        this.image = post.getImage();
        this.date = post.getDate().toString();
        this.offering = post.isOffering();
        this.userId = post.getUser().getId();
        this.categoryId = post.getCategory().getId();
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isOffering() {
        return offering;
    }

    public void setOffering(boolean offering) {
        this.offering = offering;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
