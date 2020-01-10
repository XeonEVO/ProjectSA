package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact,Long>{
    Contact findById(long id);
}