package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.Producer;

@RestController
public class MyController {

	@Autowired
	private Producer producer;
	
	@GetMapping(path = "/publish/{message}")
	public void sendMessageToKafkaTopic(@PathVariable("message") String message){
	            this.producer.sendMessage(message);
	}

}
