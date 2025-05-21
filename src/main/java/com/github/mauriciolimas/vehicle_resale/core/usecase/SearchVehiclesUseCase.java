package com.github.mauriciolimas.vehicle_resale.core.usecase;

import java.util.List;

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchVehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class SearchVehiclesUseCase implements UseCase<SearchVehicleRequest, PageData<VehicleResponse>> {
	
	private final VehicleRepository repository;
	private final VehicleMapper mapper;
	
	@Override
	public PageData<VehicleResponse> execute(SearchVehicleRequest input) throws BusinessException {
		PageData<Vehicle> page = repository.list(input.filter(), input.pageable());
		List<VehicleResponse> list = page.getData().stream().map(mapper::toResponse).toList();
		return PageData.from(list, page);
	}

}
