package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HateosInvoice;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.Item;
import com.example.demo.repos.HateosInvoiceRepository;
import com.example.demo.repos.ItemRepository;
import com.example.demo.services.InvoiceService;

@RestController
@CrossOrigin(origins = "*")
public class HateosInvoiceController {


	@Autowired
	private ItemRepository repo;

		@Autowired
		private HateosInvoiceRepository service;
		
	@GetMapping(path = "/api/v2/invoices")
		   public CollectionModel<Item> findAll() {
		      List<Item> allItems = this.repo.findAll();
		      
		      for (Item eachItem : allItems) {
		           int id = eachItem.getItemNumber();
		           Link selfLink = WebMvcLinkBuilder.linkTo(ItemController.class)
		                  .slash("api/v1/items/"+id).withSelfRel();
		        
		       eachItem.add(selfLink);
		       
		         }
		       
		Link link = WebMvcLinkBuilder.linkTo(HateosInvoiceController.class)
				 .withSelfRel();
		       CollectionModel<Item> result =
		    		    CollectionModel.of(allItems, link);
		       
		       return result;
		        
		}

	@PostMapping(path = "/api/v2/invoices")
		public HateosInvoice add(@RequestBody HateosInvoice entity,HttpServletResponse response) {
		    response.setStatus(201); 
			return this.service.save(entity);
		}

}
