package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaxPayer;
import com.example.demo.repos.TaxPayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaxPayerService {

	
	@Autowired
	private TaxPayerRepository repo;
	
	@Autowired
	private TaxPayer element;
	public TaxPayer findById(long id) {
		
		Optional<TaxPayer> entity =this.repo.findById(id);
		
		TaxPayer result = element;
		if(entity.isPresent()) {
			result = entity.get();
		} 
			return result;
		
	}
	
   public TaxPayer findByPan(String pan) {
		
	   log.info("Find By Pan with => "+pan +"=> Called");
		return this.repo.findByPan(pan);
		
		
	}
	
}
