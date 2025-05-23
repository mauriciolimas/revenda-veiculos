package com.github.mauriciolimas.vehicle_resale.adapter.response;

import java.math.BigDecimal;
import java.time.Instant;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyTransaction {

	private String code;
	private String vehicle;
	private BigDecimal value;
	private TransactionStatus status;
	private Instant completedData;

}