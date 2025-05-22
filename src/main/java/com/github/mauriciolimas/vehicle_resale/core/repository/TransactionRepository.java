package com.github.mauriciolimas.vehicle_resale.core.repository;

import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;

public interface TransactionRepository {

	Transaction save(Transaction transaction);
}
