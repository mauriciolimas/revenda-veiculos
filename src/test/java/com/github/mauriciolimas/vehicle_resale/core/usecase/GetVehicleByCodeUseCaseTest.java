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

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.util.VehicleMockUtil;

@ExtendWith(MockitoExtension.class)
class GetVehicleByCodeUseCaseTest {

	@Mock
	VehicleRepository repository;
	
	VehicleMapper mapper;
	
	@BeforeEach
	void setup() {
		this.mapper = Mappers.getMapper(VehicleMapper.class);
	}
	
	@Test
	void test_getVehicle() throws BusinessException {
		Mockito.when(repository.findByCode(Mockito.anyString())).thenReturn(Optional.of(VehicleMockUtil.vehicle()));
		GetVehicleByCodeUseCase useCase = new GetVehicleByCodeUseCase(repository, mapper);
		VehicleResponse response = useCase.execute("SALE000001");
		assertNotNull(response);
	}
	
	@Test
	void test_notGetVehicle() {
		Mockito.when(repository.findByCode(Mockito.anyString())).thenReturn(Optional.empty());
		GetVehicleByCodeUseCase useCase = new GetVehicleByCodeUseCase(repository, mapper);
		assertThrows(VehicleNotFoundException.class, () -> useCase.execute("SALE000001"));
	}
}
