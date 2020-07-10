package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CibilScoreDTO {

	private int id;
	private String panNumber;
	private String firstName;
	private String lastName;
	private String location;
	private double score;
	
	}


