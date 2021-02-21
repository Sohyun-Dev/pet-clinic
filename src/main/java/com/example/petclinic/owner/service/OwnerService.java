package com.example.petclinic.owner.service;

import com.example.petclinic.owner.dto.OwnerCreateDto;
import com.example.petclinic.owner.entity.Owner;
import com.example.petclinic.owner.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner createOwnerBy(OwnerCreateDto ownerCreateDto) {
        String firstName = ownerCreateDto.getFirstName();
        String lastName = ownerCreateDto.getLastName();
        String address = ownerCreateDto.getAddress();
        String city = ownerCreateDto.getCity();
        String telephone = ownerCreateDto.getTelephone();

        Owner owner = new Owner(
                ownerCreateDto.getFirstName(),
                ownerCreateDto.getLastName(),
                ownerCreateDto.getAddress(),
                ownerCreateDto.getCity(),
                ownerCreateDto.getTelephone()
        );

        // 1. 우리는 query 를 작성하지 않았다.  --> JPA
        // 2. 우리는 DB table 을 만들지 않았다. --> JPA, DB : h2

        return ownerRepository.save(owner); // insert query 를 알아서 만들어줌
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }


    public Optional<Owner> getOwnerBy(Long id) {
         return ownerRepository.findById(id);
        // Java 8에 추가된 기능 Optional --->
        // if value is null, wrapping by Optional class
    }
}

// ORM : Object Relational Mapping 자바의 객체와 데이터베이스의 테이블을 매핑시켜줌
    // 1. 객체를 생성한다.
    // 2. JPA 한테 이 객체를 저장해줘~ 라고 부탁한다.
    // 3. JPA 는 query 를 생성한다.
    // 4. JPA 는 query 를 실행한다.
    // => 객체지향적으로 개발 가능

// JPA : Java Persistence API
//     : ORM 을 하기 위한 Java 표준 스펙
