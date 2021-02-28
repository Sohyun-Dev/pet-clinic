package com.example.petclinic.pet.service;

import com.example.petclinic.pet.dto.PetCreateDto;
import com.example.petclinic.pet.entity.Pet;
import com.example.petclinic.pet.repository.PetRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPetBy(PetCreateDto petCreateDto){
        Pet pet = new Pet(
                petCreateDto.getName(),
                petCreateDto.getGender()
        );
        return petRepository.save(pet);
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPet(@PathVariable Long id){

        return petRepository.findById(id);
    }
}
