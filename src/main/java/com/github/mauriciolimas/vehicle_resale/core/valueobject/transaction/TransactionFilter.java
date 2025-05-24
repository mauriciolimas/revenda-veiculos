package com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction;

import java.math.BigDecimal;

import org.springdoc.core.annotations.ParameterObject;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ParameterObject
public class TransactionFilter {

	@Parameter(required = false, description = "Status da transação")
	private TransactionStatus status;
	@Parameter(required = false, description = "Valor mínimo da transação")
	private BigDecimal minValue;
	@Parameter(required = false, description = "Valor máximo da transação")
	private BigDecimal maxValue;
}
