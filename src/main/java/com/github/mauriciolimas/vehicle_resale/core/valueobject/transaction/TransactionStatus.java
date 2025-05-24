package com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction;

import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransactionStatus {

	WAITING_FOR_PAYMENT(1),
	COMPLETED(2),
	CANCELLED(3);
	
	private Integer code;
	
	public static TransactionStatus fromCode(Integer code) {
		return Stream.of(TransactionStatus.values()).filter(transaction -> transaction.getCode().equals(code)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Transaction status code " + code + " not found"));
	}
}
