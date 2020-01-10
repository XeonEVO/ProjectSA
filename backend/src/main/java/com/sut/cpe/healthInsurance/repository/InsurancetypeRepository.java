package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Insurancetype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InsurancetypeRepository extends JpaRepository<Insurancetype, Long> {
    Insurancetype findById(long id);
}