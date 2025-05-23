package com.github.mauriciolimas.vehicle_resale.core.repository;

import java.util.Optional;

import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;

public interface TransactionRepository {
	
	Optional<Transaction> findByCode(String code);

	PageData<Transaction> list(TransactionFilter filter, Pageable pageable);
	
	Transaction save(Transaction transaction);
}
