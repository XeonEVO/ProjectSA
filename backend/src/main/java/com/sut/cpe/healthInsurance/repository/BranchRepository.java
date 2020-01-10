package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BranchRepository extends JpaRepository<Branch,Long>{
    Branch findById(long id);
}