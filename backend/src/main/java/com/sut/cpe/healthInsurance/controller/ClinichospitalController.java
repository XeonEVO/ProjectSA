package com.sut.cpe.healthInsurance.controller;
import com.sut.cpe.healthInsurance.repository.ClinichospitalRepository;
import com.sut.cpe.healthInsurance.entity.Clinichospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ClinichospitalController {
    @Autowired
    private final ClinichospitalRepository clinichospitalRepository;

    public ClinichospitalController(ClinichospitalRepository clinichospitalRepository) {
        this.clinichospitalRepository = clinichospitalRepository;
    }

    @GetMapping("/clinichospital")
    public Collection<Clinichospital> Clinichospitals() {
        return clinichospitalRepository.findAll().stream().collect(Collectors.toList());
    }

}