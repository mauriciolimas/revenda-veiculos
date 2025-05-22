package com.github.mauriciolimas.vehicle_resale.infra.database.repository;

import org.springframework.stereotype.Component;

import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity.TransactionJpaEntity;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.repository.TransactionJpaRepository;
import com.github.mauriciolimas.vehicle_resale.infra.database.mapper.TransactionMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
	
	private final TransactionJpaRepository repository;
	private final TransactionMapper mapper;
	
	@Override
	public Transaction save(Transaction transaction) {
		TransactionJpaEntity entity = mapper.toJpaEntity(transaction);
		repository.save(entity);
		return mapper.toEntity(entity);
	}

}
