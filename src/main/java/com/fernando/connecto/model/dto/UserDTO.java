package com.fernando.connecto.model.dto;

public class UserDTO {

    private long id;
    private String name;
    private String profilePicture;

    public UserDTO(long id, String name, String profilePicture) {
        this.id = id;
        this.name = name;
        this.profilePicture = profilePicture;
    }

    public UserDTO() {
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
}
