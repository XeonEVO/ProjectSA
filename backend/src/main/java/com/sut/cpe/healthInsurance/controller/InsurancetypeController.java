package com.sut.cpe.healthInsurance.controller;

import com.sut.cpe.healthInsurance.entity.Insurancetype;
import com.sut.cpe.healthInsurance.repository.InsurancetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InsurancetypeController {

    @Autowired
    private final InsurancetypeRepository insurancetypeRepository;

    public InsurancetypeController(InsurancetypeRepository insurancetypeRepository) {
        this.insurancetypeRepository = insurancetypeRepository;
    }

    @GetMapping("/insurancetype")
    public Collection<Insurancetype> Insurancetypes() {
        return insurancetypeRepository.findAll().stream().collect(Collectors.toList());
    }
}