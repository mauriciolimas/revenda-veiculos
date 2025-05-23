package com.github.mauriciolimas.vehicle_resale.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.mauriciolimas.vehicle_resale.adapter.TransactionMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchTransactionRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;

@ExtendWith(MockitoExtension.class)
class ListTransactionsUseCaseTest {

	@Mock
	TransactionRepository repository;
	
	TransactionMapper mapper;
	
	ListTransactionsUseCase useCase;
	
	@BeforeEach
	void setup() {
		this.mapper = Mappers.getMapper(TransactionMapper.class);
		this.useCase = new ListTransactionsUseCase(repository, mapper);
	}
	
	@Test
	void test_listTransactions() throws BusinessException {
		PageData<Transaction> pageData = new PageData<Transaction>();
		pageData.setData(List.of());
		Mockito.when(repository.list(Mockito.any(), Mockito.any())).thenReturn(pageData);
		PageData<TransactionResponse> data = useCase.execute(new SearchTransactionRequest(new TransactionFilter(), new Pageable()));
		assertNotNull(data);
	}
}
