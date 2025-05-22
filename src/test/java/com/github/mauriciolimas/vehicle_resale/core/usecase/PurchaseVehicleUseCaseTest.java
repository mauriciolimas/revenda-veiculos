package com.github.mauriciolimas.vehicle_resale.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.mauriciolimas.vehicle_resale.adapter.request.PurchaseRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.PurchaseResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotAvailableException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.service.AuthenticationService;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.util.TransactionMockUtil;
import com.github.mauriciolimas.vehicle_resale.util.UserMockUtil;
import com.github.mauriciolimas.vehicle_resale.util.VehicleMockUtil;

@ExtendWith(MockitoExtension.class)
class PurchaseVehicleUseCaseTest {

	@Mock
	VehicleRepository vehicleRepository;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@Mock
	AuthenticationService authenticationService;

	PurchaseVehicleUseCase usecase;
	
	@BeforeEach
	void setup() {
		this.usecase = new PurchaseVehicleUseCase(vehicleRepository, transactionRepository, authenticationService);
	}
	
	@Test
	void test_createPurchase() throws BusinessException {
		when(vehicleRepository.findByCode(anyString())).thenReturn(Optional.of(VehicleMockUtil.vehicle()));
		when(transactionRepository.save(any())).thenReturn(TransactionMockUtil.transaction());
		when(authenticationService.getAuthenticatedUser()).thenReturn(UserMockUtil.user());
	
		PurchaseResponse response = usecase.execute(new PurchaseRequest("SALE000001"));
		assertNotNull(response);
	}
	
	@Test
	void test_failedPurchaseVehicleNotFound() {
		when(vehicleRepository.findByCode(anyString())).thenReturn(Optional.empty());
		assertThrows(VehicleNotFoundException.class, () -> usecase.execute(new PurchaseRequest("SALE000001")));
	}
	
	@Test
	void test_failedPurchaseVehicleWithStatusInvalid() {
		Vehicle vehicle = VehicleMockUtil.vehicle();
		vehicle.setStatus(VehicleStatus.RESERVED);
		when(vehicleRepository.findByCode(anyString())).thenReturn(Optional.of(vehicle));
		assertThrows(VehicleNotAvailableException.class, () -> usecase.execute(new PurchaseRequest("SALE000001")));
	}
}
