package com.sut.cpe.healthInsurance.controller;
import com.sut.cpe.healthInsurance.repository.PaychecksRepository;
import com.sut.cpe.healthInsurance.entity.Paychecks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PaychecksController {

    @Autowired
    private final PaychecksRepository paychecksRepository;

    public  PaychecksController(PaychecksRepository  paychecksRepository) {
        this.paychecksRepository = paychecksRepository;
    }

    @GetMapping("/paychecks")
    public Collection<Paychecks> Paycheckss() {
        return paychecksRepository.findAll().stream().collect(Collectors.toList());
    }
}