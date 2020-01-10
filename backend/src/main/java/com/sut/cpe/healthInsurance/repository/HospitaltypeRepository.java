package com.sut.cpe.healthInsurance.repository;
import com.sut.cpe.healthInsurance.entity.Hospitaltype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HospitaltypeRepository extends JpaRepository<Hospitaltype,Long>{
    Hospitaltype findById(long id);
}