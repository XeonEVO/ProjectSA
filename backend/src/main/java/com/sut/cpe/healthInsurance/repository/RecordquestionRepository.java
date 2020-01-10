package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Recordquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecordquestionRepository extends JpaRepository<Recordquestion,Long>{
}