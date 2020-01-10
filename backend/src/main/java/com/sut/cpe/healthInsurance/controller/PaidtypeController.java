package com.sut.cpe.healthInsurance.controller;

import com.sut.cpe.healthInsurance.entity.Paidtype;
import com.sut.cpe.healthInsurance.repository.PaidtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PaidtypeController {

    @Autowired
    private final PaidtypeRepository paidtypeRepository;

    public PaidtypeController(PaidtypeRepository paidtypeRepository) {
        this.paidtypeRepository = paidtypeRepository;
    }

    @GetMapping("/paidtype")
    public Collection<Paidtype> Paidtypes() {
        return paidtypeRepository.findAll().stream().collect(Collectors.toList());
    }
}