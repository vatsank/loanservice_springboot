package com.example.demo.utils;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
	
	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message){
		System.out.println("Consumed Message"+message);
	log.info("Consumed Message -> "+message);
	}

}
