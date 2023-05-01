package com.realtimeexpert.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.realtimeexpert.model.TaxCaluclation;
import com.realtimeexpert.proxy.TaxDetailsProxy;


@RestController
public class TaxCaluclationController {
	
	@Autowired
	private TaxDetailsProxy taxDetailsProxy;

	@GetMapping("/tax-caluclation/for/{fo}/amount/{amount}")
	public TaxCaluclation caluclatetaxfornewregim(@PathVariable BigDecimal fo, @PathVariable BigDecimal amount ) {
		
		TaxCaluclation taxCaluclation = taxDetailsProxy.retriewTaxDetails(fo);
		return new TaxCaluclation(taxCaluclation.getId(),fo,
				amount,taxCaluclation.getTaxmultiple(),
				amount.multiply(taxCaluclation.getTaxmultiple().divide(BigDecimal.valueOf(10))),taxCaluclation.getEnvironment());
	}
}
