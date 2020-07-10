package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "scb_cibilscores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CibilScore extends RepresentationModel<CibilScore>{

	@Id
	private int id;
	private String pan;
	private String firstName;
	private String lastName;
	private String location;
	private double score;
	
		
	
}


