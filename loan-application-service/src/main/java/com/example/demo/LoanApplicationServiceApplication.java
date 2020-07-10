package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.LoanApplication;
import com.example.demo.repo.LoanApplicationRepository;

@SpringBootApplication
public class LoanApplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplicationServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {

			@Autowired
			LoanApplicationRepository repo;

			@Override
			public void run(String... args) throws Exception {
				
				
			  repo.save(new LoanApplication(100, "Ramesh", 500000, "AAXPAB449S"));
				
			}
		};
		
	}

}
