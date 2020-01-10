package com.sut.cpe.healthInsurance.controller;

import com.sut.cpe.healthInsurance.entity.Branch;
import com.sut.cpe.healthInsurance.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;




@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BranchController {

    @Autowired
    private final BranchRepository branchRepository;

    public  BranchController(BranchRepository  branchRepository) {
        this.branchRepository = branchRepository;
    }

    @GetMapping("/branch")
    public Collection<Branch> Branchs() {
        return branchRepository.findAll().stream().collect(Collectors.toList());
    }
}