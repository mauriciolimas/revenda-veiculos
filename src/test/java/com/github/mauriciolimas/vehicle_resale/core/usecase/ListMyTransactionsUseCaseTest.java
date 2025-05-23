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
import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchMyTransaction;
import com.github.mauriciolimas.vehicle_resale.adapter.response.MyTransaction;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.service.AuthenticationService;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;
import com.github.mauriciolimas.vehicle_resale.util.UserMockUtil;

@ExtendWith(MockitoExtension.class)
class ListMyTransactionsUseCaseTest {

	@Mock
	TransactionRepository transactionRepository;
	
	@Mock
	AuthenticationService authenticationService;
	
	TransactionMapper mapper;
	
	ListMyTransactionsUseCase useCase;
	
	@BeforeEach
	void setup() {
		mapper = Mappers.getMapper(TransactionMapper.class);
		useCase = new ListMyTransactionsUseCase(transactionRepository, authenticationService, mapper);
	}
	
	
	@Test
	void test_listMyTransactions() throws BusinessException {
		PageData<Transaction> page = new PageData<Transaction>();
		page.setData(List.of());
		Mockito.when(authenticationService.getAuthenticatedUser()).thenReturn(UserMockUtil.user());
		Mockito.when(transactionRepository.findByBuyerId(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(page);
		PageData<MyTransaction> response = useCase.execute(new SearchMyTransaction(new TransactionFilter(), new Pageable()));
		assertNotNull(response);
	}
}
