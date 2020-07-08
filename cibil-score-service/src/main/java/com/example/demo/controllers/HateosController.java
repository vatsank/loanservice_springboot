package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.services.CibilScoreService;

@RestController
public class HateosController {

	@Autowired
	private CibilScoreService service;
	
	@GetMapping(path = "/api/v2/cibilscores")
	public List<CibilScore> findAll(){
		
		List<CibilScore> scores= this.service.findAll();
		
	}
	
	@GetMapping(path = "/api/v2/cibilscores/{id}")
	public CibilScore findById(@PathVariable("id") int id){
		
		return this.service.findById(id);
	}
	
}
