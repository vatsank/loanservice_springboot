package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Invoice;
import com.example.demo.repos.InvoiceRepository;

@Service
public class InvoiceService {

	
	@Autowired
	 private  InvoiceRepository repo ;
	
	@Autowired
	private List<Invoice> list;
	    
	     public List<Invoice> findAll(){
	             return repo.findAll();
	   }
	     
	   public Optional<Invoice> findById(int id) {
    	   return repo.findById(id);
	   } 

	    public Iterable<Invoice> findAllSorted(String propName){
	    	        Sort sortBy = Sort.by (propName);
	    	        return this.repo.findAll (sortBy); 
	    	        }

	    
	    public List<Invoice> findByPage(int page, int size, String propName){
	    	   
	        Pageable paging = 
	               PageRequest.of(page,size,Sort.by(propName).ascending ());
	        
	               Page<Invoice> pagedResult = repo.findAll(paging);
	                if(pagedResult.hasContent()) {
	                	 return pagedResult.getContent();
	                         } else {
	            	   return list;
	            	   }
	               }

	    public Invoice remove(Invoice entity) {
	    	   
	        Invoice resp = null;
	       
	     if(repo.existsById(entity.getInvoiceNumber())) {
	        
	        repo.delete(entity);
	        
	        resp= entity;
	        } 
	        
	        return resp;
	       }

		public Invoice add(Invoice entity) {
						return this.repo.save(entity);
		}

	    

}


