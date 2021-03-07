package com.example.petclinic.pet.service;

import com.example.petclinic.owner.entity.Owner;
import com.example.petclinic.owner.service.OwnerService;
import com.example.petclinic.pet.dto.PetCreateDto;
import com.example.petclinic.pet.dto.PetUpdateDto;
import com.example.petclinic.pet.entity.Pet;
import com.example.petclinic.pet.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private PetRepository petRepository;
    private OwnerService ownerService;

    public PetService(PetRepository petRepository, OwnerService ownerService) {
        this.petRepository = petRepository;
        this.ownerService = ownerService;
    }

    public Pet createPetBy(PetCreateDto petCreateDto){
        Optional<Owner> ownerBy = ownerService.getOwnerBy(petCreateDto.getOwnerId());
        Owner owner = ownerBy.get(); // 데이터베이스에서 찾은 객체?

        Pet pet = new Pet();
        pet.setName(petCreateDto.getName());
        pet.setGender(petCreateDto.getGender());
        pet.setOwner(owner);


        owner.add(pet);

        return petRepository.save(pet);
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetBy(@PathVariable Long id){
        return petRepository.findById(id);
    }

    public Pet updatePetBy(@PathVariable Long id, PetUpdateDto petUpdateDto){
        Optional<Pet> findById = petRepository.findById(id); // JVM memory에 있는 DB를 가리키고 있음(접근하기 위해서), 그래서 new를 할 필요 없음
        Pet pet = findById.get(); // Optional이 감싸져있기 때문에
        // Pet pet = petRepository.findById(petId).orElseThrow(EntityNotFoundException::new);
        // pet.updateBy(petUpdateDto);
        // return pet;
        pet.setName(petUpdateDto.getName());
        pet.setGender(petUpdateDto.getGender());
        return petRepository.save(pet);
    }

    public void deletePetBy(Long id){
        Pet pet = petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        petRepository.delete(pet);
    }

}
