package com.fernando.connecto.controller;

import com.fernando.connecto.model.Category;
import com.fernando.connecto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById (@PathVariable long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<Category>> findAll (){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody @Valid Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable long id, @RequestBody @Valid Category category){
        return ResponseEntity.ok(categoryService.update(id, category));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

}
