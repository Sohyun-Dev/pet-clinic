package com.example.petclinic.visit.service;

import com.example.petclinic.owner.service.OwnerService;
import com.example.petclinic.pet.entity.Pet;
import com.example.petclinic.pet.service.PetService;
import com.example.petclinic.visit.dto.VisitCreateDto;
import com.example.petclinic.visit.dto.VisitUpdateDto;
import com.example.petclinic.visit.entity.Visit;
import com.example.petclinic.visit.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {
    private VisitRepository visitRepository;
    private OwnerService ownerService;
    private PetService petService;

    public VisitService(VisitRepository visitRepository, OwnerService ownerService, PetService petService) {
        this.visitRepository = visitRepository;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    public Visit createVisitBy(VisitCreateDto visitCreateDto) {
        Optional<Pet> petBy = petService.getPetBy(visitCreateDto.getPetId());
        Pet pet = petBy.get();

        Visit visit = new Visit();
        visit.setVisitDate(visitCreateDto.getVisitDate());
        visit.setDescription(visitCreateDto.getDescription());
        visit.setPet(pet);

        return visitRepository.save(visit);
    }

    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisit(@PathVariable Long id) {
        return visitRepository.findById(id);
    }

    public Visit updateVisit(Long id, VisitUpdateDto visitUpdateDto) {
        Optional<Visit> byId = visitRepository.findById(id);
        Visit visit = byId.get();
        visit.setDescription(visitUpdateDto.getDescription());
        visit.setVisitDate(visitUpdateDto.getVisitDate());
        return visitRepository.save(visit);
    }

    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
