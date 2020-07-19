package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Producer {

	private static final String TOPIC = "users";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	
	public void sendMessage(String message){
	log.info(String.format("$$ -> Producing message --> %s",message));
	ListenableFuture<SendResult<String, String>> future =
			          this.kafkaTemplate.send(TOPIC,message);
	
	  future.addCallback(new SuccessCallback<Object>() {

		@Override
		public void onSuccess(Object result) {
			log.info("success called "+result.toString());
			
		}
	},new FailureCallback() {
		
		@Override
		public void onFailure(Throwable ex) {

			log.info("Failure");
		}
	});	
	  
	}

}
