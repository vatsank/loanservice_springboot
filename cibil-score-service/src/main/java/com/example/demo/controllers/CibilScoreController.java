package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CibilScore;
import com.example.demo.entity.CibilScoreDTO;
import com.example.demo.entity.Response;
import com.example.demo.entity.TaxPayerDTO;
import com.example.demo.services.CibilScoreService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class CibilScoreController {

	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CibilScoreService service;
	
	@Value("server.port")
	private String port;
	
	@GetMapping(path = "/api/v1/cibilscores",produces = "application/hal+json")
	public List<CibilScore> findAll(){
		log.info("find all called");
		log.info("response from"+port);
		return this.service.findAll();
	}
	
	@GetMapping(path = "/api/v1/cibilscores/{pan}",produces = "application/hal+json")
	public Response findByPan(@PathVariable("pan") String pan) {
		
	
		CibilScore score =this.service.findByPan(pan);
		
		 TaxPayerDTO tax= getTaxDetails(pan);
		
		log.info("Cibil Scores Called"+score.toString());
		
		Response resp = new Response();
		resp.setScore(score);
		resp.setTax(tax);
		System.out.println(resp);
		return resp;
	}
	
	@PostMapping(path = "/api/v1/cibilscores")
	public CibilScore add(@RequestBody CibilScore entity) {
		
		log.info("add cibil score called");
		return this.service.save(entity);
	}
	
	public TaxPayerDTO getTaxDetails(String pan) {
		
		
		
		TaxPayerDTO dto=this.template.getForObject("http://taxpayer-service/api/v1/taxpayers/"+pan, TaxPayerDTO.class);
	
		System.out.println(dto);
		
		return dto;
	}
}
