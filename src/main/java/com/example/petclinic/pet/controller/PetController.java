package com.example.petclinic.pet.controller;

import com.example.petclinic.owner.dto.OwnerCreateDto;
import com.example.petclinic.owner.entity.Owner;
import com.example.petclinic.pet.dto.PetCreateDto;
import com.example.petclinic.pet.entity.Pet;
import com.example.petclinic.pet.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/pets")
    public Pet createPet(@Valid PetCreateDto petCreateDto){

        return petService.createPetBy(petCreateDto);
    }

    // TODO: Read : DB에 저장된 모든 Owner 를 읽기
    @GetMapping("/pets")
    public List<Pet> getPets(){ // Java Collection Framework 에 List 정의되어 있음

        return petService.getPets();
    }

    @GetMapping("/pets/{id}")
    public Optional<Pet> getPet(@PathVariable Long id){

        return petService.getPetBy(id);
    }
}
