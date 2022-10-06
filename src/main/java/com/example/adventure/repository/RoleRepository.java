package com.example.adventure.repository;

import com.example.adventure.model.ERole;
import com.example.adventure.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
