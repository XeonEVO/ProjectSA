package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);
    Customer findByIdentification(String identification);
}