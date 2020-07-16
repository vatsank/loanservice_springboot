package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemDetails;
import com.example.demo.repos.ItemDetailsRepository;
import com.example.demo.repos.ItemRepository;
import com.example.demo.services.InvoiceService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	private ItemRepository service;
	
	
	@Autowired
	private ItemDetailsRepository repo;
	
@GetMapping(path = "/api/v1/items")
	   public CollectionModel<Item> findAll() {
	      List<Item> allItems = service.findAll();
	      
	      
	      
	       for (Item eachItem : allItems) {
	           int id = eachItem.getItemNumber();
	           Link selfLink = WebMvcLinkBuilder.linkTo(InvoiceController.class)
	                  .slash("api/v1/items/"+id).withSelfRel();
	        
	       eachItem.add(selfLink);
	       
	         }
	       
	Link link = WebMvcLinkBuilder.linkTo(InvoiceController.class)
			 .withSelfRel();
	       CollectionModel<Item> result =
	    		    CollectionModel.of(allItems, link);
	       return result;
	}

@PostMapping(path = "/api/v1/items")
	public Item add(@RequestBody Item entity,HttpServletResponse response) {
	    response.setStatus(201); 
		return this.service.save(entity);
	}


@PutMapping(path = "/api/v1/items")
	public Item update(@RequestBody Item entity) {

	return this.service.save(entity);
	}

	
@DeleteMapping(path = "/api/v1/items")
	public Item remove(@RequestBody Item entity,
			       HttpServletResponse response) {

	try {
		  boolean found = this.service.existsById(entity.getItemNumber());
	       if (!found){
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Requested Entry Not Found");          
	       } else {
		       this.service.delete(entity);

	       }
	}catch(ResponseStatusException e) {
	throw e;
	}
	       return entity ;
	    }

@GetMapping(path="/api/v1/items/{itemNumber}")
    public ItemDetails findByItemNumber(@PathVariable("itemNumber") int itemNumber){
		
		   return this.repo.findById(itemNumber).get();
		   }
	


}
