package com.ironyard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironyard.springboot.data.Pet;

public interface PetRepo extends JpaRepository<Pet, Long>{
  List<Pet> findByBreed(String breed);
}
