package com.example.springboot_ajax.service;

import com.example.springboot_ajax.model.Animal;

import java.util.List;
import java.util.Optional;

public interface IAnimalService {
    List<Animal> findAll();

    Optional<Animal> findById(Long id);

    Animal save(Animal animal);

    void deleteById(Long id);
}
