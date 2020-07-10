package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.TaxPayer;

@RepositoryRestResource
public interface TaxPayerRepository extends JpaRepository<TaxPayer, Long> {

	TaxPayer findByPan(String pan);
}
