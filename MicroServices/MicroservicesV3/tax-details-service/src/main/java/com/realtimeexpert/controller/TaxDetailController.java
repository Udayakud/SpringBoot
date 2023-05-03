package com.realtimeexpert.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.realtimeexpert.model.TaxDetail;
import com.realtimeexpert.repo.TaxDetailsRepo;

@RestController
public class TaxDetailController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private TaxDetailsRepo repo;
	
	@GetMapping("/tax-details/for/{fo}")
	public TaxDetail retrieveTaxDetails(@PathVariable BigDecimal fo) {
	
		TaxDetail taxDetail = repo.findByFo(fo);
		if(taxDetail==null) {
			throw new RuntimeException("Unable to find the valoe please select between 3,6,9,12,15,16");
		}
		String port=environment.getProperty("local.server.port");
		taxDetail.setEnvironment(port);
		return taxDetail;
	}
}
