package com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionFilter {

	private TransactionStatus status;
	private BigDecimal minValue;
	private BigDecimal maxValue;
}
