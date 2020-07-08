package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "scb_cibilscores")
public class CibilScore extends RepresentationModel<CibilScore>{

	@Id
	private int id;
	private String panNumber;
	private String firstName;
	private String lastName;
	private String location;
	private double score;
	
	public CibilScore() {
		super();
		
		System.out.println("Cibil Score Initialized");
	}
	public CibilScore(int id, String panNumber, String firstName, String lastName, String location, double score) {
		super();
	
		System.out.println("Cibil Score Parameter Constuctor Initialized ");

		this.id = id;
		this.panNumber = panNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		
		System.out.println("Set ID Method Called");
		this.id = id;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "CibilScore [id=" + id + ", panNumber=" + panNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", location=" + location + ", score=" + score + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((panNumber == null) ? 0 : panNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CibilScore other = (CibilScore) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (panNumber == null) {
			if (other.panNumber != null)
				return false;
		} else if (!panNumber.equals(other.panNumber))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}
	
	
	
}
