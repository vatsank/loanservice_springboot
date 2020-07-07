package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanApplication {

	
	long applicationNumber;
	
	// Using Field DI on Property

	@Autowired(required = false)
	@Qualifier(value = "suresh")
	Customer customer;
	
	double loanAmount;
}
