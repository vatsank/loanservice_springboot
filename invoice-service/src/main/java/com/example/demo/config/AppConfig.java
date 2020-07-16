package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.entity.Invoice;
import com.example.demo.repos.HateosInvoiceRepository;

@Configuration
public class AppConfig {

	@Bean
	public List<Invoice> emptyList(){
		
		List<Invoice> invoice= new ArrayList<>();
	
		return invoice;
	}
	
	
	}

