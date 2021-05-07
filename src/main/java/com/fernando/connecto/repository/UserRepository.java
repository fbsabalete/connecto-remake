package com.fernando.connecto.repository;

import com.fernando.connecto.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByEmailIgnoreCase(String email);
}
