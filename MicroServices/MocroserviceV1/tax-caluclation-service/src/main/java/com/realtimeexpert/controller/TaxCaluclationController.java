package com.realtimeexpert.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.realtimeexpert.model.TaxCaluclation;


@RestController
public class TaxCaluclationController {

	@GetMapping("/tax-caluclation/for/{fo}/amount/{amount}")
	public TaxCaluclation caluclatetaxfornewregim(@PathVariable BigDecimal fo, @PathVariable BigDecimal amount ) {
		
		HashMap<String,BigDecimal> uriValbles=new HashMap<>();
		uriValbles.put("fo",fo);
		
		ResponseEntity<TaxCaluclation> forEntity = new  RestTemplate().getForEntity("http://localhost:8000/tax-details/for/{fo}",TaxCaluclation.class,uriValbles);
		TaxCaluclation taxCaluclation = forEntity.getBody();
		return new TaxCaluclation(taxCaluclation.getId(),fo,
				amount,taxCaluclation.getTaxmultiple(),
				amount.multiply(taxCaluclation.getTaxmultiple()),taxCaluclation.getEnvironment());
	}
}
