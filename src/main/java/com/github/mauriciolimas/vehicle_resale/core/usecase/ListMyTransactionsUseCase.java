package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.adapter.TransactionMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchMyTransaction;
import com.github.mauriciolimas.vehicle_resale.adapter.response.MyTransaction;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.service.AuthenticationService;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.authentication.User;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class ListMyTransactionsUseCase implements UseCase<SearchMyTransaction, PageData<MyTransaction>> {
	
	private final TransactionRepository transactionRepository;
	private final AuthenticationService authenticationService;
	private final TransactionMapper mapper;
	
	@Override
	public PageData<MyTransaction> execute(SearchMyTransaction input) throws BusinessException {
		User user = authenticationService.getAuthenticatedUser();
		PageData<Transaction> page = transactionRepository.findByBuyerId(user.getId(), input.getFilter(), input.getPageable());
		return PageData.from(page.getData().stream().map(mapper::toMyTransaction).toList(), page);
	}

}
