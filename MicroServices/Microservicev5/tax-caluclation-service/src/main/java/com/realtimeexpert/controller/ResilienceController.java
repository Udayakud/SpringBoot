package com.realtimeexpert.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ResilienceController {
	
	private Logger logger = LoggerFactory.getLogger(ResilienceController.class);
	@GetMapping("/message")
	//@Retry(name="sample",fallbackMethod = "sampleapi")
	@CircuitBreaker(name="sampe",fallbackMethod ="sampleapi" )
	public String sampleMessage() {
		logger.info("Attempt received->{}{}");
		ResponseEntity<String> rt=new RestTemplate().getForEntity("http://localhost:9999/dummy", String.class);
		return rt.getBody();
	}
	
	public String sampleapi(Exception e){
		return "Fall back method";
	}

}
