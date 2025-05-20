package com.github.mauriciolimas.vehicle_resale.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.util.VehicleMockUtil;

@ExtendWith(MockitoExtension.class)
class CreateVehicleUseCaseTest {

	@Mock
	VehicleRepository repository;
	
	VehicleMapper mapper;
	
	@BeforeEach
	void setup() {
		this.mapper = Mappers.getMapper(VehicleMapper.class);
	}
	
	@Test
	void test_createVehicle() throws BusinessException {
		Mockito.when(repository.save(Mockito.any())).thenReturn(VehicleMockUtil.vehicle());
		
		CreateVehicleUseCase useCase = new CreateVehicleUseCase(repository, mapper);
		VehicleRequest request = VehicleMockUtil.vehicleRequest();
		VehicleResponse response = useCase.execute(request);
		assertNotNull(response);
	}
}
