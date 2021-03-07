package com.example.petclinic.owner.controller;

import com.example.petclinic.owner.dto.OwnerCreateDto;
import com.example.petclinic.owner.entity.Owner;
import com.example.petclinic.owner.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {

        this.ownerService = ownerService;
    }

    @PostMapping("/owners")
    public Owner createOwner(@Valid OwnerCreateDto ownerCreateDto){ //사용자의 요청을 객체로 받기 위해 createdto사용, 유효성 검사를 하겠다

        return ownerService.createOwnerBy(ownerCreateDto);
    }

    // TODO: Read : DB에 저장된 모든 Owner 를 읽기
    @GetMapping("/owners")
    public List<Owner> getOwners(){ // Java Collection Framework 에 List 정의되어 있음

        return ownerService.getOwners();
    }

    @GetMapping("/owners/{id}")
    public Optional<Owner> getOwner(@PathVariable Long id){

        return ownerService.getOwnerBy(id);
    }

    // TODO: Update


    // TODO: Delete


}
