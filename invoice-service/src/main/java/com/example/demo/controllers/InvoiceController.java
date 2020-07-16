package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.Invoice;
import com.example.demo.services.InvoiceService;

@RestController
@CrossOrigin(origins = "*")
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
@GetMapping(path = "/api/v1/invoices")
	   public List<Invoice> findAll() {
	      List<Invoice> details = service.findAll();
	        return details;
	}

@PostMapping(path = "/api/v1/invoices")
	public Invoice add(@RequestBody Invoice entity,HttpServletResponse response) {
	    response.setStatus(201); 
		return this.service.add(entity);
	}


@PutMapping(path = "/api/v1/invoices")
	public Invoice update(@RequestBody Invoice entity) {

	return this.service.add(entity);
	}

	
@DeleteMapping(path = "/api/v1/invoices")
	public Invoice remove(@RequestBody Invoice entity,
			       HttpServletResponse response) {

	try {
	       Invoice deleted = this.service.remove(entity);
	       if (deleted==null){
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Requested Entry Not Found");          
	       }
	}catch(ResponseStatusException e) {
	throw e;
	}
	       return entity ;
	    }

@GetMapping(path="/api/v1/invoices/paging/{page}/{size}/{propName}")
    public List<Invoice> findByPage(@PathVariable("page") int page, 
    		 @PathVariable("size") int size, 
    		  @PathVariable("propName") String propName){
		
		   return this.service.findByPage (page,size,propName);
		   }
	


}
