package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path = "/api/v1/points",produces = "application/hal+json")
	public String fetchScores() {
		
		return template.getForObject("http://CIBILE-SCORE-SERVICE/api/v2/cibilscores",String.class);
		
	}
}
