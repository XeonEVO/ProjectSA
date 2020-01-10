package com.sut.cpe.healthInsurance.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.sut.cpe.healthInsurance.entity.*;
import com.sut.cpe.healthInsurance.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class HospitalController {
    @Autowired
    private final HospitalRepository hospitalRepository;
    @Autowired
    private ClinichospitalRepository clinichospitalRepository;
    @Autowired
    private HospitaltypeRepository hospitaltypeRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
  
    HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/hospital")
    public Collection<Hospital> hospitals() {
        return hospitalRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/hospital/{hname}/{clinichospital_id}/{hospitaltype_id}/{province_id}")
    public Hospital newHospital(
    @PathVariable String hname,
    @PathVariable long clinichospital_id,
    @PathVariable long hospitaltype_id,
    @PathVariable long province_id) {
    Hospital newHospital = new Hospital();
    Clinichospital clinichospital = clinichospitalRepository.findById(clinichospital_id);
    Hospitaltype hospitaltype = hospitaltypeRepository.findById(hospitaltype_id);
    Province province = provinceRepository.findById(province_id);
    newHospital.setHname(hname);
    newHospital.setClinichospital(clinichospital);
    newHospital.setHospitaltype(hospitaltype);
    newHospital.setProvince(province);
    
    return hospitalRepository.save(newHospital); 
    
    }
}