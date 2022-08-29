package com.example.springboot_ajax.repository;

import com.example.springboot_ajax.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal, Long> {
}
