package com.github.mauriciolimas.vehicle_resale.adapter.response;

import java.math.BigDecimal;

public record PurchaseResponse(
		String transactionCode,
		BigDecimal value,
		String status
		) {}
