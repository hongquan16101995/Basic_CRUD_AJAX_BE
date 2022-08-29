package com.example.springboot_ajax.controller;

import com.example.springboot_ajax.model.Animal;
import com.example.springboot_ajax.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private IAnimalService iAnimalService;

    @GetMapping
    public ResponseEntity<List<Animal>> findAll() {
        List<Animal> animals = iAnimalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable("id") Long id) {
        Optional<Animal> animalOptional = iAnimalService.findById(id);
        if (animalOptional.isPresent()) {
            return new ResponseEntity<>(animalOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody Animal animal) {
        Animal animalCreate = iAnimalService.save(animal);
        return new ResponseEntity<>(animalCreate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable("id") Long id,
                                         @RequestBody Animal animal) {
        Optional<Animal> animalOptional = iAnimalService.findById(id);
        if (animalOptional.isPresent()) {
            animal.setId(id);
            Animal animalUpdate = iAnimalService.save(animal);
            return new ResponseEntity<>(animalUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Animal> delete(@PathVariable("id") Long id) {
        Optional<Animal> animalOptional = iAnimalService.findById(id);
        if (animalOptional.isPresent()) {
            iAnimalService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
