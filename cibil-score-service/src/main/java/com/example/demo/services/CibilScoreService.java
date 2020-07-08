package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CibilScore;
import com.example.demo.ifaces.CibilScoreRepository;

@Service
public class CibilScoreService {

	
	@Autowired
	private CibilScoreRepository repo;
	
	
	public List<CibilScore> findAll(){
		
		return this.repo.findAll();
	}
	
	public CibilScore save(CibilScore entity) {
		
		return this.repo.save(entity);
	}
	
      public CibilScore findById(int id) {
		
		return this.repo.findById(id).get();
	}
      
}
