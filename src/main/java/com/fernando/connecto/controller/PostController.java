package com.fernando.connecto.controller;

import com.fernando.connecto.model.Post;
import com.fernando.connecto.service.CategoryService;
import com.fernando.connecto.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable long id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody @Valid Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable long id, @RequestBody @Valid Post post){
        return ResponseEntity.ok(postService.update(id, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        postService.delete(id);
        return ResponseEntity.ok().build();
    }

}
