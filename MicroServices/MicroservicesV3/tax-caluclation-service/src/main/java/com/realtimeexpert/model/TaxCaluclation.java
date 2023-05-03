package com.realtimeexpert.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxCaluclation {
	
	private Long id;
	
	@JsonProperty("for")
	private BigDecimal fo;
	private BigDecimal amount;
	private BigDecimal taxmultiple;
	private BigDecimal totalTaxCaluclated;
	private String environment;
	public TaxCaluclation(Long id, BigDecimal fo, BigDecimal amount, BigDecimal taxmultiple,
			BigDecimal totalTaxCaluclated, String environment) {
		super();
		this.id = id;
		this.fo = fo;
		this.amount = amount;
		this.taxmultiple = taxmultiple;
		this.totalTaxCaluclated = totalTaxCaluclated;
		this.environment = environment;
	}
	public TaxCaluclation() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getFo() {
		return fo;
	}
	public void setFo(BigDecimal fo) {
		this.fo = fo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getTaxmultiple() {
		return taxmultiple;
	}
	public void setTaxmultiple(BigDecimal taxmultiple) {
		this.taxmultiple = taxmultiple;
	}
	public BigDecimal getTotalTaxCaluclated() {
		return totalTaxCaluclated;
	}
	public void setTotalTaxCaluclated(BigDecimal totalTaxCaluclated) {
		this.totalTaxCaluclated = totalTaxCaluclated;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	

}
