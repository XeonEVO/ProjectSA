package com.sut.cpe.healthInsurance.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sut.cpe.healthInsurance.entity.Province;
import com.sut.cpe.healthInsurance.repository.ProvinceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinceController {

    @Autowired
    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/province")
    public Collection<Province> Provinces() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

}