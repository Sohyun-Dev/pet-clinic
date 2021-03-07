package com.example.petclinic.visit.controller;

import com.example.petclinic.visit.dto.VisitCreateDto;
import com.example.petclinic.visit.dto.VisitUpdateDto;
import com.example.petclinic.visit.entity.Visit;
import com.example.petclinic.visit.service.VisitService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VisitController {
    private VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("/visits")
    public Visit createVisit(@Valid VisitCreateDto visitCreateDto){ // Valid annotation : 유효성 검사(객체가 유효한지)
        return visitService.createVisitBy(visitCreateDto);
    }

    @GetMapping("/visits")
    public List<Visit> getVisits(){
        return visitService.getVisits();
    }

    @GetMapping("/visits/{id}")
    public Optional<Visit> getVisit(@PathVariable Long id){
        return visitService.getVisit(id);
    }

    @PutMapping("/visits/{id}")
    public void updateVisit(@PathVariable Long id, @Valid VisitUpdateDto visitUpdateDto){
        visitService.updateVisit(id, visitUpdateDto);
    }

    @DeleteMapping("/visits/{id}")
    public void deleteVisit(@PathVariable Long id){
        visitService.deleteVisit(id);
    }
}
