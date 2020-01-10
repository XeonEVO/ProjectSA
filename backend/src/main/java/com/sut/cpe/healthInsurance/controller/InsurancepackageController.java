package com.sut.cpe.healthInsurance.controller;

import com.sut.cpe.healthInsurance.entity.Insurancepackage;
import com.sut.cpe.healthInsurance.repository.InsurancepackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InsurancepackageController {

    @Autowired
    private final InsurancepackageRepository insurancepackageRepository;

    public InsurancepackageController(InsurancepackageRepository insurancepackageRepository) {
        this.insurancepackageRepository = insurancepackageRepository;
    }

    @GetMapping("/insurancepackage")
    public Collection<Insurancepackage> Insurancepackages() {
        return insurancepackageRepository.findAll().stream().collect(Collectors.toList());
    }
}