package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.CibilScoreController;
import com.example.demo.entity.CibilScore;
import com.example.demo.ifaces.CibilScoreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CibilScoreService {

	
	@Autowired
	private CibilScoreRepository repo;
	
	
	public List<CibilScore> findAll(){

		log.info("Find  All in service called");
		return this.repo.findAll();
	}
	
	public CibilScore save(CibilScore entity) {
		
		log.info("save in service called");
		return this.repo.save(entity);
	}
	
      public CibilScore findById(int id) {
		
		return this.repo.findById(id).get();
	}
      
      public CibilScore findByPan(String panNumber) {
  		
  		return this.repo.findByPan(panNumber);
  		
  		
  	}
}
