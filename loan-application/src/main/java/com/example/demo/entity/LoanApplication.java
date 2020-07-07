package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanApplication {

	
	long applicationNumber;
	
	// Using Field DI on Property

	@Autowired
	Customer customer;
	
	double loanAmount;
}
