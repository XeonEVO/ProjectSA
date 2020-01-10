package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HospitalRepository extends JpaRepository<Hospital,Long>{
    Hospital findById(long id);
}