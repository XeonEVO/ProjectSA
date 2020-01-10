package com.sut.cpe.healthInsurance.controller;
import com.sut.cpe.healthInsurance.repository.HospitaltypeRepository;
import com.sut.cpe.healthInsurance.entity.Hospitaltype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class HospitaltypeController {
    @Autowired
    private final HospitaltypeRepository hospitaltypeRepository;

    public HospitaltypeController(HospitaltypeRepository hospitaltypeRepository) {
        this.hospitaltypeRepository = hospitaltypeRepository;
    }

    @GetMapping("/hospitaltype")
    public Collection<Hospitaltype> Hospitaltypes() {
        return hospitaltypeRepository.findAll().stream().collect(Collectors.toList());
    }

}