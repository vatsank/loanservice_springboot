package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taxPayer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaxPayer {

	@Id
	long id;
	String name;
	String gender;
	String residential_status;
	String pan;
	String entity;
	

}
