package com.example.adventure.service;

import com.example.adventure.model.Requirements;
import com.example.adventure.model.User;
import com.example.adventure.repository.RequirementsRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RequirementsJPA implements RequirementsService{

    public final RequirementsRepository requirementsRepository;

    public RequirementsJPA(RequirementsRepository requirementsRepository) {
        this.requirementsRepository = requirementsRepository;
    }

    @Override
    public Set<Requirements> findAll() {
        Set<Requirements> set = new HashSet<>();
        requirementsRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Requirements save(Requirements object) {
        return requirementsRepository.save(object);
    }

    @Override
    public void delete(Requirements object) {
        requirementsRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        requirementsRepository.deleteById(aLong);
    }

    @Override
    public Optional<Requirements> findById(Long aLong) {
        return requirementsRepository.findById(aLong);
    }
}
