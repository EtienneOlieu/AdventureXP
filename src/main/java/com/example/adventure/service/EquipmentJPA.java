package com.example.adventure.service;

import com.example.adventure.model.Equipment;
import com.example.adventure.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EquipmentJPA implements EquipmentService{

    private final EquipmentRepository equipmentRepository;

    public EquipmentJPA(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Set<Equipment> findAll() {
     Set<Equipment> set = new HashSet<>();
     equipmentRepository.findAll().forEach(set::add);
     return set;
    }

    @Override
    public Equipment save(Equipment object) {
        return equipmentRepository.save(object);
    }

    @Override
    public void delete(Equipment object) {
        equipmentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
         equipmentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Equipment> findById(Long aLong) {
        return equipmentRepository.findById(aLong);
    }
}
