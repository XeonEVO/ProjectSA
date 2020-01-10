package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Treatmethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TreatmethodRepository extends JpaRepository<Treatmethod,Long>{
    Treatmethod findById(long id);
}