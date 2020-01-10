package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Paidtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaidtypeRepository extends JpaRepository<Paidtype, Long> {
    Paidtype findById(long id);
}