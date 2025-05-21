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

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchVehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleFilter;

@ExtendWith(MockitoExtension.class)
class SearchVehiclesUseCaseTest {

	@Mock
	VehicleRepository repository;
	
	VehicleMapper mapper;
	
	@BeforeEach
	void setup() {
		this.mapper = Mappers.getMapper(VehicleMapper.class);
	}
	
	@Test
	void test_searchVehicles() throws BusinessException {
		PageData<Vehicle> pageData = new PageData<>();
		pageData.setData(List.of());
		Mockito.when(repository.list(Mockito.any(), Mockito.any())).thenReturn(pageData);
		SearchVehiclesUseCase useCase = new SearchVehiclesUseCase(repository, mapper);
		PageData<VehicleResponse> response = useCase.execute(new SearchVehicleRequest(new VehicleFilter(), new Pageable()));
		assertNotNull(response);
	}
}
