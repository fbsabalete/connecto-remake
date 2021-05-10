package com.fernando.connecto.controller;

import com.fernando.connecto.model.Post;
import com.fernando.connecto.model.dto.PostDTO;
import com.fernando.connecto.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDTO>> findByUserId(@PathVariable long userId){
        return ResponseEntity.ok(postService.findByUserId(userId).stream().map(PostDTO::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@RequestBody @Valid Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(new PostDTO(postService.save(post)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable long id, @RequestBody @Valid Post post){
        return ResponseEntity.ok(new PostDTO(postService.update(id, post)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        postService.delete(id);
        return ResponseEntity.ok().build();
    }

}
