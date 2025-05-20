package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class GetVehicleByCodeUseCase implements UseCase<String, VehicleResponse> {
	
	private final VehicleRepository repository;
	private final VehicleMapper mapper;
	
	@Override
	public VehicleResponse execute(String code) throws BusinessException {
		Vehicle vehicle = repository.findByCode(code).orElseThrow(() -> new VehicleNotFoundException(code));
		return mapper.toResponse(vehicle);
	}

}
