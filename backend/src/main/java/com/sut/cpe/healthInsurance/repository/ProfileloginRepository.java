package com.sut.cpe.healthInsurance.repository;


import com.sut.cpe.healthInsurance.entity.Profilelogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfileloginRepository extends JpaRepository<Profilelogin,Long>{
    Profilelogin findByUsername(String username);
}