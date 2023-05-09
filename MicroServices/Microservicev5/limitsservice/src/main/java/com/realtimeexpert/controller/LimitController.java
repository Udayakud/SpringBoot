package com.realtimeexpert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtimeexpert.model.Configuration;
import com.realtimeexpert.model.Limit;


@RestController
public class LimitController {
	
	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public Limit retriewLimit() {
		return new Limit(10,1000);
	}
	
	@GetMapping("/limits-config")
	public Limit retriewLimitConfi() {
		return new Limit(config.getMin(),config.getMax());
	}
}
