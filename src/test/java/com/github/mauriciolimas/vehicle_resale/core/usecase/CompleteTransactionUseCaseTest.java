package com.github.mauriciolimas.vehicle_resale.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.mauriciolimas.vehicle_resale.adapter.TransactionMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.TransactionCompleteRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.TransactionNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.util.TransactionMockUtil;
import com.github.mauriciolimas.vehicle_resale.util.VehicleMockUtil;

@ExtendWith(MockitoExtension.class)
class CompleteTransactionUseCaseTest {

	@Mock
	TransactionRepository transactionRepository;
	
	@Mock
	VehicleRepository vehicleRepository;

	TransactionMapper mapper;
	
	CompleteTransactionUseCase useCase;
	
	@BeforeEach
	void setup() {
		mapper = Mappers.getMapper(TransactionMapper.class);
		useCase = new CompleteTransactionUseCase(transactionRepository, vehicleRepository, mapper);
	}
	
	@Test
	void test_completeTransaction() throws BusinessException {
		Mockito.when(transactionRepository.findByCode(Mockito.anyString())).thenReturn(Optional.of(TransactionMockUtil.transaction()));
		Mockito.when(vehicleRepository.findByCode(Mockito.anyString())).thenReturn(Optional.of(VehicleMockUtil.vehicle()));
		TransactionResponse response = useCase.execute(new TransactionCompleteRequest("code", true));
		assertNotNull(response);
	}
	
	@Test
	void test_cancelledTransaction() throws BusinessException {
		Mockito.when(transactionRepository.findByCode(Mockito.anyString())).thenReturn(Optional.of(TransactionMockUtil.transaction()));
		Mockito.when(vehicleRepository.findByCode(Mockito.anyString())).thenReturn(Optional.of(VehicleMockUtil.vehicle()));
		TransactionResponse response = useCase.execute(new TransactionCompleteRequest("code", false));
		assertNotNull(response);
	}
	
	@Test
	void test_noCompleteBecauseTransactionNotFound() throws BusinessException {
		Mockito.when(transactionRepository.findByCode(Mockito.anyString())).thenReturn(Optional.empty());
		assertThrows(TransactionNotFoundException.class, () -> useCase.execute(new TransactionCompleteRequest("code", true)));
	}
	
	@Test
	void test_noCompletedBecauseVehicleNotFound() {
		Mockito.when(transactionRepository.findByCode(Mockito.anyString())).thenReturn(Optional.of(TransactionMockUtil.transaction()));
		Mockito.when(vehicleRepository.findByCode(Mockito.anyString())).thenReturn(Optional.empty());
		assertThrows(VehicleNotFoundException.class, () -> useCase.execute(new TransactionCompleteRequest("code", true)));
	}
}
