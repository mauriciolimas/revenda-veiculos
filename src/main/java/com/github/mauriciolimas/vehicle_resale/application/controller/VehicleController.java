package com.github.mauriciolimas.vehicle_resale.application.controller;

import org.springframework.stereotype.Component;

import com.github.mauriciolimas.vehicle_resale.adapter.request.SearchVehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.usecase.CreateVehicleUseCase;
import com.github.mauriciolimas.vehicle_resale.core.usecase.GetVehicleByCodeUseCase;
import com.github.mauriciolimas.vehicle_resale.core.usecase.SearchVehiclesUseCase;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleFilter;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VehicleController {

	private final SearchVehiclesUseCase searchVehiclesUseCase;
	private final CreateVehicleUseCase createVehicleUseCase;
	private final GetVehicleByCodeUseCase getVehicleByCodeUseCase;
	
	public PageData<VehicleResponse> list(VehicleFilter filter, Pageable pageable) throws BusinessException {
		return searchVehiclesUseCase.execute(new SearchVehicleRequest(filter, pageable));
	}
	
	public VehicleResponse create(VehicleRequest request) throws BusinessException {
		return createVehicleUseCase.execute(request);
	}
	
	public VehicleResponse findByCode(String code) throws BusinessException {
		return getVehicleByCodeUseCase.execute(code);
	}
}
