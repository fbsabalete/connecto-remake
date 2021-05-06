package com.fernando.connecto.repository;

import com.fernando.connecto.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
