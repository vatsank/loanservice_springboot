package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.ifaces.CibilScoreRepository;

@RestController
public class CibilScoreController {

	
	@Autowired
	private CibilScoreRepository repo;
	
	@GetMapping(path = "/api/v1/cibilscores")
	public List<CibilScore> findAll(){
		
		return this.repo.findAll();
	}
}
