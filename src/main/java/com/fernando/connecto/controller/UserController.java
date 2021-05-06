package com.fernando.connecto.controller;

import com.fernando.connecto.model.User;
import com.fernando.connecto.model.UserLogin;
import com.fernando.connecto.model.dto.LoginDTO;
import com.fernando.connecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<User> save(@RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody UserLogin user){
        return ResponseEntity.ok(userService.login(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable long id, @RequestBody @Valid User user){
        return ResponseEntity.ok(userService.update(id, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }

}
