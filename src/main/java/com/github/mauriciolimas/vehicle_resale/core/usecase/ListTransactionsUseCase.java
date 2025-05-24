package com.github.mauriciolimas.vehicle_resale.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import com.github.mauriciolimas.vehicle_resale.adapter.TransactionMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchTransactionRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class ListTransactionsUseCase implements UseCase<SearchTransactionRequest, PageData<TransactionResponse>> {
	
	private final TransactionRepository repository;
	private final TransactionMapper mapper;
	
	@Override
	public PageData<TransactionResponse> execute(SearchTransactionRequest input) throws BusinessException {
		PageData<Transaction> page = repository.list(input.getFilter(), input.getPageable());
		List<TransactionResponse> list = page.getData().stream().map(mapper::toResponse).collect(Collectors.toList());
		return PageData.from(list, page);
	}

}
