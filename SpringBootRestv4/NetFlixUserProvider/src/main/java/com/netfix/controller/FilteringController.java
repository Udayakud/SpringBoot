package com.netfix.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.netfix.model.RandomValues;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public MappingJacksonValue getRandomValue() {
		
		RandomValues randomValues = new RandomValues("f1","f2","f3");
		
	
		SimpleBeanPropertyFilter filterpr=SimpleBeanPropertyFilter.filterOutAllExcept("v1","v2");
		FilterProvider filter=new SimpleFilterProvider().addFilter("someFilter",filterpr);
		MappingJacksonValue mj=new MappingJacksonValue(randomValues);
		mj.setFilters(filter);
		return mj;
	}
	
	//Dynamic FIltering --- MappingJacksonValue
	
	@GetMapping("/filter/prime")
	public List<RandomValues> getAllMovies() {
		return Arrays.asList(new RandomValues("f1","f2","f3"),new RandomValues("f4","f5","f6"));
	}

}
