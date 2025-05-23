package com.github.mauriciolimas.vehicle_resale.application.controller;

import org.springframework.stereotype.Component;

import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchTransactionRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.usecase.ListTransactionsUseCase;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionController {

	private final ListTransactionsUseCase listTransactionsUseCase;
	
	public PageData<TransactionResponse> list(TransactionFilter filter, Pageable pageable) throws BusinessException {
		return listTransactionsUseCase.execute(new SearchTransactionRequest(filter, pageable));
	}
}
