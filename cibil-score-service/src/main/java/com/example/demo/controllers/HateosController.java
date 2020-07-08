package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.services.CibilScoreService;

@RestController
public class HateosController {

	@Autowired
	private CibilScoreService service;
	
	@GetMapping(path = "/api/v2/cibilscores")
	public CollectionModel<CibilScore> findAll(){
		
		List<CibilScore> scores= this.service.findAll();
		
		for(CibilScore eachScore:scores) {
			
			Link link = WebMvcLinkBuilder.linkTo(HateosController.class)
					             .slash("api/v2/cibilscores/"+eachScore.getId())
					                 .withSelfRel();
			
			eachScore.add(link);
		}
		
		Link link = WebMvcLinkBuilder.linkTo(HateosController.class).withSelfRel();
		CollectionModel<CibilScore> model = CollectionModel.of(scores, link);
		
		return model;
	}
	
	@GetMapping(path = "/api/v2/cibilscores/{id}")
	public EntityModel<CibilScore> findById(@PathVariable("id") int id){
		
		CibilScore score = this.service.findById(id);
		
		Link link = WebMvcLinkBuilder.linkTo(HateosController.class).withSelfRel();

		EntityModel<CibilScore> model = EntityModel.of(score,link);
		
		return model;
	}
	
}
