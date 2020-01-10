package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Claim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClaimRepository extends JpaRepository<Claim,Long>{
}