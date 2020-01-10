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
public class HealthInsuranceController {
    @Autowired
    private final HealthInsuranceRepository healthinsuranceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InsurancepackageRepository insurancepackageRepository;
    @Autowired
    private InsurancetypeRepository insurancetypeRepository;
    @Autowired
    private PaidtypeRepository paidtypeRepository;

    
    
    HealthInsuranceController(HealthInsuranceRepository healthinsuranceRepository){
            this.healthinsuranceRepository = healthinsuranceRepository;
        }


        @GetMapping("/healthinsurance")//ไว้ดึงข้อมูทั้งหมด
        public Collection<HealthInsurance> HealthInsurances(){
            return healthinsuranceRepository.findAll().stream().collect(Collectors.toList());
        }
        @PostMapping("/healthinsurance/{insurancetype_id}/{paidtype_id}/{insurancepackage_id}/{employee_id}/{customer_id}")
            public HealthInsurance newHealthinsurance(HealthInsurance newHealthinsurance,
            @PathVariable long insurancetype_id,
            @PathVariable long paidtype_id,
            @PathVariable long insurancepackage_id,
            @PathVariable long employee_id,
            @PathVariable long customer_id){
            
            Insurancetype insurancetype = insurancetypeRepository.findById(insurancetype_id);
            Paidtype paidtype = paidtypeRepository.findById(paidtype_id);
            Insurancepackage insurancepackage = insurancepackageRepository.findById(insurancepackage_id);
            Employee employee = employeeRepository.findById(employee_id);
            Customer customerHealthInsurance = customerRepository.findById(customer_id);

            
            newHealthinsurance.setInsurancetype(insurancetype);
            newHealthinsurance.setPaidtype(paidtype);
            newHealthinsurance.setInsurancepackage(insurancepackage);
            newHealthinsurance.setCustomerHealthInsurance(customerHealthInsurance);
            newHealthinsurance.setEmployee(employee);
            
            
            
           


                return healthinsuranceRepository.save(newHealthinsurance);
            }
}