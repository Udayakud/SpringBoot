package com.realtimeexpert.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class TaxDetail {
	@Id
	private Long id;
	@Column(name="tax_for")
	@JsonProperty("for")
	private BigDecimal fo;
	
	private BigDecimal taxmultiple;
	
	private String environment;

	public TaxDetail(Long id, BigDecimal fo, BigDecimal taxmultiple) {
		super();
		this.id = id;
		this.fo = fo;
		this.taxmultiple = taxmultiple;
	}

	public TaxDetail() {
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

	public BigDecimal getTaxmultiple() {
		return taxmultiple;
	}

	public void setTaxmultiple(BigDecimal taxmultiple) {
		this.taxmultiple = taxmultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
}
