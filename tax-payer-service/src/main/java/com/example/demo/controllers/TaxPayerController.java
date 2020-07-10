package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TaxPayer;
import com.example.demo.services.TaxPayerService;

@RestController
@CrossOrigin(origins = "*")
public class TaxPayerController {

	@Autowired
	private TaxPayerService service;
	

	@GetMapping(value = "/api/v1/taxpayers/{pan}",produces = "application/hal+json")
	public TaxPayer findById(@PathVariable("pan") String pan) {
		
	
		return this.service.findByPan(pan);
	}
	
}
