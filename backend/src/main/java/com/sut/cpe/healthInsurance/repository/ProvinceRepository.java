package com.sut.cpe.healthInsurance.repository;

import com.sut.cpe.healthInsurance.entity.Province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ProvinceRepository extends JpaRepository<Province, Long> {
	Province findById(long id);
}