package com.fernando.connecto.service;

import com.fernando.connecto.exceptions.ObjectNotFoundException;
import com.fernando.connecto.model.Post;
import com.fernando.connecto.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Post> findAll (){
        List<Post> postList = new ArrayList<Post>();
        postRepository.findAll().forEach(postList::add);
        return postList;
    }

    public Post findById(long id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.isPresent() ? obj.get() : obj.orElseThrow(() -> new ObjectNotFoundException("Post id="+id + " not found"));
    }

    public Post save(Post post){
        categoryService.findById(post.getCategory().getId());
        return postRepository.save(post);
    }

    public Post update(long id, Post post){
        findById(id);
        categoryService.findById(post.getCategory().getId());
        post.setId(id);
        return postRepository.save(post);
    }

    public void delete(long id){
        findById(id);
        postRepository.deleteById(id);
    }

}
