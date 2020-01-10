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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sut.cpe.healthInsurance.entity.*;
import com.sut.cpe.healthInsurance.repository.*;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ReceiptController {
    @Autowired
    private final ReceiptRepository receiptRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PaidtypeRepository paidtypeRepository;
   
   
    
    
        ReceiptController(ReceiptRepository receiptRepository){
            this.receiptRepository = receiptRepository;
        }


        @GetMapping("/receipt")
        public Collection<Receipt> Receipts(){
            return receiptRepository.findAll().stream().collect(Collectors.toList());
        }
        @PostMapping("/receipt/{identification}/{paidtype_id}/{employee_id}/{branch_id}")
            public Receipt newReceipt(Receipt newReceipt,
            @PathVariable String identification,
            @PathVariable long paidtype_id,
            @PathVariable long employee_id,
            @PathVariable long branch_id){
            
            Customer customer = customerRepository.findByIdentification(identification);
            Paidtype paidtype = paidtypeRepository.findById(paidtype_id);
            Employee employee = employeeRepository.findById(employee_id);
            Branch branch = branchRepository.findById(branch_id);
           

            newReceipt.setCustomer(customer);
            newReceipt.setPaidtype(paidtype);
            newReceipt.setEmployee(employee);
            newReceipt.setBranch(branch);
            newReceipt.setReceiptDate(new Date());
           

                return receiptRepository.save(newReceipt);
            }
}
