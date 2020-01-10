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
public class RecordquestionController {
    @Autowired
    private final RecordquestionRepository recordquestionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private HeadingRepository headingRepository;

    RecordquestionController(RecordquestionRepository recordquestionRepository) {
        this.recordquestionRepository = recordquestionRepository;
    }

    @GetMapping("/recordquestion")
    public Collection<Recordquestion> Recordquestions() {
        return recordquestionRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/recordquestion/{identification}/{contact_id}/{branch_id}/{heading_id}/{detail}")
    public Recordquestion newRecordquestion(@PathVariable String identification, @PathVariable long contact_id, @PathVariable long branch_id, @PathVariable long heading_id,@PathVariable String detail) {
        Recordquestion newRecordquestion = new Recordquestion();
        Customer createdBy = customerRepository.findByIdentification(identification);
        Contact contact = contactRepository.findById(contact_id);
        Branch branch = branchRepository.findById(branch_id);
        Heading heading = headingRepository.findById(heading_id);
        
        newRecordquestion.setCreatedBy(createdBy);
        newRecordquestion.setContact(contact);
        newRecordquestion.setBranch(branch);
        newRecordquestion.setHeading(heading);
        newRecordquestion.setDetail(detail);
       
        return recordquestionRepository.save(newRecordquestion);
    }
}