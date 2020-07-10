package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.TaxPayer;
import com.example.demo.repos.TaxPayerRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class TaxPayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxPayerServiceApplication.class, args);
	}

	@Bean
	public TaxPayer payer() {
		
		return new TaxPayer();
	}
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			TaxPayerRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
			
				repo.save(new TaxPayer(1030L, "Ramesh", "Male", "individual", "AAXPAB449S", "selfemployed"));
			}
		};
	}
}
