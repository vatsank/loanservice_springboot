package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "hateos_invoice")
public class HateosInvoice extends RepresentationModel<HateosInvoice> {

	    @Id
	    int  invoiceNumber;
	    String customerName;
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    LocalDate invoiceDate;
	    double amount;
		
	    @OneToMany(targetEntity =Item.class,  cascade = CascadeType.ALL,
	    		        fetch=FetchType.EAGER)
	    @JoinColumn(name = "invoice_ref" , referencedColumnName = "invoiceNumber")
        Set<Item> items;
	}



