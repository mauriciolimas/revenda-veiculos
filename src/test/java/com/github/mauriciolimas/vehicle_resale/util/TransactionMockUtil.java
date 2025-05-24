package com.github.mauriciolimas.vehicle_resale.util;

import java.time.Instant;
import java.util.UUID;

import com.github.mauriciolimas.vehicle_resale.core.entity.Buyer;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;

public class TransactionMockUtil {

	public static Transaction transaction() {
		Transaction transaction = new Transaction();
		transaction.setCode(UUID.randomUUID().toString());
		transaction.setStatus(TransactionStatus.WAITING_FOR_PAYMENT);
		transaction.setCreatedAt(Instant.now());
		transaction.setUpdatedAt(Instant.now());
		transaction.setBuyer(new Buyer(UUID.randomUUID().toString(), "Samara Morgan", "samara.morgan@ochamado.com"));
		transaction.setVehicle(VehicleMockUtil.vehicle());
		return transaction;
	}

}
