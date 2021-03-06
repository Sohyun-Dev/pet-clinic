package com.example.petclinic.pet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PetCreateDto {


    @NotNull
    private Long ownerId;
    // 항상 클라이언트로부터 입력받아야함

    @NotEmpty
    private String name;

    @NotEmpty
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
