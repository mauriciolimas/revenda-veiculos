package com.github.mauriciolimas.vehicle_resale.infra.database.repository;

import static com.github.mauriciolimas.vehicle_resale.infra.database.specifications.CommonsSpecifications.hasEnum;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity.TransactionJpaEntity;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.repository.TransactionJpaRepository;
import com.github.mauriciolimas.vehicle_resale.infra.database.mapper.TransactionJpaMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
	
	private final TransactionJpaRepository repository;
	private final TransactionJpaMapper mapper;
	
	@Override
	public Optional<Transaction> findByCode(String code) {
		Optional<TransactionJpaEntity> optional = repository.findById(code);
		if(optional.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(mapper.toEntity(optional.get()));
	}
	
	@Override
	public Transaction save(Transaction transaction) {
		TransactionJpaEntity entity = mapper.toJpaEntity(transaction);
		repository.save(entity);
		return mapper.toEntity(entity);
	}

	@Override
	public PageData<Transaction> list(TransactionFilter filter, Pageable pageable) {
		Specification<TransactionJpaEntity> spec = Specification.where(hasEnum(filter.getStatus(), "status"));
		Page<TransactionJpaEntity> page = repository.findAll(spec, pageable.getPageRequest());
		List<Transaction> list = page.getContent().stream().map(mapper::toEntity).collect(Collectors.toList());
		return PageData.from(list, page);
	}

}
