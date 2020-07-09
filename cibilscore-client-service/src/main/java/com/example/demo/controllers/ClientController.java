package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class ClientController {

	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path = "/api/v1/points")
	public String fetchScores() {
		
		return template.getForObject("http://CIBILE-SCORE-SERVICE/api/v1/cibilscores",String.class);
		
	}
}
