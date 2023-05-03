package com.realtimeexpert.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.realtimeexpert.model.TaxCaluclation;


@FeignClient(name="tax-details")
public interface TaxDetailsProxy {

	@GetMapping("/tax-details/for/{fo}")
	public TaxCaluclation retriewTaxDetails(
			@PathVariable BigDecimal fo);
}
