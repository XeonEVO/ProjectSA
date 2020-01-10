package com.sut.cpe.healthInsurance.repository;
import com.sut.cpe.healthInsurance.entity.Clinichospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClinichospitalRepository extends JpaRepository<Clinichospital,Long>{
    Clinichospital findById(long id);
}