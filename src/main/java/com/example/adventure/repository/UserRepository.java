package com.example.adventure.repository;

import com.example.adventure.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
