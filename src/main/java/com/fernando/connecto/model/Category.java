package com.fernando.connecto.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=2, max = 255) @NotEmpty @NotNull
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Post> post;

    public Category() {
    }

    public Category(long id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.post = post;
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

    public List<Post> getPost() {
        return post;
    }

    public void addPost(Post post) {
        this.post.add(post);
    }
}
