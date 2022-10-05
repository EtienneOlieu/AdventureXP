package com.example.adventure.service;

import com.example.adventure.model.Shift;
import com.example.adventure.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ShiftJPA implements ShiftService{
    private final ShiftRepository shiftRepository;

    public ShiftJPA(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    @Override
    public Set<Shift> findAll() {
        Set allShifts = new HashSet();
        shiftRepository.findAll().forEach(allShifts::add);
        return allShifts;
    }

    @Override
    public Shift save(Shift object) {
        return shiftRepository.save(object);
    }

    @Override
    public void delete(Shift object) {
        shiftRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        shiftRepository.deleteById(aLong);
    }

    @Override
    public Optional<Shift> findById(Long aLong) {
        return shiftRepository.findById(aLong);
    }
}
