package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.entity.LoanApplication;

@SpringBootApplication
public class LoanApplicationExample {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(LoanApplicationExample.class, args);

		LoanApplication app = ctx.getBean(LoanApplication.class);
		
		System.out.println(app);
	
	}

	// Using Constructor DI with Factory Method
	
	@Bean
	public Customer ramesh() {
		
		return new Customer(102,"Ramesh");
	}
	
	// Using Setter DI with Factory Method

	@Bean
	public LoanApplication app1() {
		
		LoanApplication application = new LoanApplication();
		 
		application.setApplicationNumber(2021);
		application.setLoanAmount(500000.00);
		
		return application;
	
	}
}
