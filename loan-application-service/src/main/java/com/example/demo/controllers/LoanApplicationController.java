package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CibilScoreDTO;
import com.example.demo.entity.LoanApplication;
import com.example.demo.entity.LoanApplicationDTO;
import com.example.demo.entity.Response;
import com.example.demo.entity.TaxPayerDTO;
import com.example.demo.repo.LoanApplicationRepository;

import lombok.Data;

@RestController
@Data
public class LoanApplicationController {

	@Autowired
	private LoanApplicationDTO dto;
	
	@Autowired
	private LoanApplicationRepository repo;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path = "/api/v1/details/{loanNumber}",produces = "application/hal+json")
	public LoanApplicationDTO fetchScores(@PathVariable("loanNumber") long loanNumber) {

		LoanApplication foundElement = repo.findById(loanNumber).get();

		Response resp =getScore(foundElement.getPanNumber());
		
		dto.setResp(resp);
		dto.setLoan(foundElement);
      	
		
		return dto;
	}
	
	public Response getScore(String panNumber) {
		
		Response resp= template.
				 getForObject("http://CIBIL-SCORE-SERVICE/api/v1/cibilscores/"+panNumber,Response.class);
		
		return resp;
	}
}

