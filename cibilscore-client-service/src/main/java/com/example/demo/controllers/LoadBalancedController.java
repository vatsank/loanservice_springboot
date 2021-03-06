package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoadBalancedController {

	@Autowired
	@Qualifier(value = "wlb")
	private RestTemplate template;
	
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	
	public LoadBalancedController() {
		super();
	log.info("Load Balancer Initalized");
	}


	@GetMapping(path = "/api/v2/points")
	public String fetchScores() {
		
		log.info("Fetch Scores Called");
		ServiceInstance instance = loadBalancer.choose("cibile-score-service");
		
			String baseURI = instance.getUri().toString();
		//return template.getForObject(baseURI+"/api/v2/cibilscores",String.class);
		
		String resp=template.getForObject(baseURI+"/api/v2/cibilscores",String.class)+ baseURI;
			
		return resp;
		
	}
}
