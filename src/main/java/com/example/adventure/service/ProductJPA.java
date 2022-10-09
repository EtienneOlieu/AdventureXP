package com.example.adventure.service;

import com.example.adventure.model.Product;
import com.example.adventure.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductJPA implements ProductService {

    private final ProductRepository productRepository;

    public ProductJPA(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<Product> findAll() {
     Set<Product> set = new HashSet<>();
     productRepository.findAll().forEach(set::add);
     return set;
    }

    @Override
    public Product save(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(Product object) {
        productRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
         productRepository.deleteById(aLong);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepository.findById(aLong);
    }
}
