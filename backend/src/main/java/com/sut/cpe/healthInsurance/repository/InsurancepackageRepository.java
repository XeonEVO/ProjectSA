package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Insurancepackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InsurancepackageRepository extends JpaRepository<Insurancepackage, Long> {
    Insurancepackage findById(long id);
}