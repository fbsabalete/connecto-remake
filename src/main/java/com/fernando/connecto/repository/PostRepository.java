package com.fernando.connecto.repository;

import com.fernando.connecto.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    public List<Post> findAllByUserId(long userId);
}
