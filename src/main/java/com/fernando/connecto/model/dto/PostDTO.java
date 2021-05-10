package com.fernando.connecto.model.dto;

import com.fernando.connecto.model.Post;

public class PostDTO {

    private long id;
    private String description;
    private String image;
    private String date;
    private boolean offering;
    private UserDTO user;
    private CategoryDTO category;

    public PostDTO(Post post) {
        this.user = new UserDTO();
        this.category = new CategoryDTO();
        this.id = post.getId();
        this.description = post.getDescription();
        this.image = post.getImage();
        this.date = post.getDate().toString();
        this.offering = post.isOffering();
        this.category.setId(post.getCategory().getId());
        this.category.setName(post.getCategory().getName());
        this.user.setId(post.getUser().getId());
        this.user.setName(post.getUser().getName());
        this.user.setProfilePicture(post.getUser().getProfilePicture());
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
