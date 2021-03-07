package com.example.petclinic.visit.dto;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VisitUpdateDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitDate;

    private String description;

    @NotNull
    private Long petId;

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
