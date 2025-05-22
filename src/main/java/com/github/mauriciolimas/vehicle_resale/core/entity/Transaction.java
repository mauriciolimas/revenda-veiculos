package com.github.mauriciolimas.vehicle_resale.core.entity;

import java.time.Instant;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	private String code;
	private Vehicle vehicle;
	private Buyer buyer;
	private TransactionStatus status;
	private Instant createdAt;
	private Instant updatedAt;

	public Transaction(Vehicle vehicle, Buyer buyer) {
		this.vehicle = vehicle;
		this.buyer = buyer;
		this.status = TransactionStatus.WAITING_FOR_PAYMENT;
	}
	
}
