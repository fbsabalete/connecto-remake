package com.fernando.connecto.model.dto;

import com.fernando.connecto.model.Portfolio;

public class PortfolioDTO {

    private long id;
    private String image;
    private long userId;

    public PortfolioDTO(Portfolio portfolio) {
        this.id = portfolio.getId();
        this.image = portfolio.getImage();
        this.userId = portfolio.getUser().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
