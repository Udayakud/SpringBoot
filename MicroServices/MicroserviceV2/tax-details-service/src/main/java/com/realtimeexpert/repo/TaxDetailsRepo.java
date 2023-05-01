package com.realtimeexpert.repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtimeexpert.model.TaxDetail;

public interface TaxDetailsRepo extends JpaRepository<TaxDetail,Long>{
	
	TaxDetail findByFo(BigDecimal fo);

}
