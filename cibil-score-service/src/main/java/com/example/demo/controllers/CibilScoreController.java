package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.services.CibilScoreService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class CibilScoreController {

	
	@Autowired
	private CibilScoreService service;
	
	@GetMapping(path = "/api/v1/cibilscores",produces = "application/hal+json")
	public List<CibilScore> findAll(){
		log.info("find all called");
		return this.service.findAll();
	}
	
	
	@PostMapping(path = "/api/v1/cibilscores")
	public CibilScore add(@RequestBody CibilScore entity) {
		
		log.info("add cibil score called");
		return this.service.save(entity);
	}
}
