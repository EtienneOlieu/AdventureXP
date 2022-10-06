//package com.example.adventure.service;
/*
import com.example.adventure.model.User;
import com.example.adventure.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class UserJPA implements UserService {

    private UserRepository userRepository;

    public UserJPA(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);

    }
    @Override
    public Optional<User> findById(Long aLong){
        return userRepository.findById(aLong);
    }
}*/
