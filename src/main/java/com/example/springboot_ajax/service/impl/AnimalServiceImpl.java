package com.example.springboot_ajax.service.impl;

import com.example.springboot_ajax.model.Animal;
import com.example.springboot_ajax.repository.IAnimalRepository;
import com.example.springboot_ajax.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements IAnimalService {

    @Autowired
    private IAnimalRepository iAnimalRepository;

    @Override
    public List<Animal> findAll() {
        return iAnimalRepository.findAll();
    }

    @Override
    public Optional<Animal> findById(Long id) {
        return iAnimalRepository.findById(id);
    }

    @Override
    public Animal save(Animal animal) {
        return iAnimalRepository.save(animal);
    }

    @Override
    public void deleteById(Long id) {
        iAnimalRepository.deleteById(id);
    }
}
