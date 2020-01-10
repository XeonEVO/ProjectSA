package com.sut.cpe.healthInsurance.repository;


import com.sut.cpe.healthInsurance.entity.Paychecks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaychecksRepository extends JpaRepository<Paychecks,Long>{
    Paychecks findById(long id);
}