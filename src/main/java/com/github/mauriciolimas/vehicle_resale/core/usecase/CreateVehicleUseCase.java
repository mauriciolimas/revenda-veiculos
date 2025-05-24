package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleInvalidException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class CreateVehicleUseCase implements UseCase<VehicleRequest, VehicleResponse> {

	private final VehicleRepository repository;
	private final VehicleMapper mapper;
	
	@Override
	public VehicleResponse execute(VehicleRequest input) throws BusinessException {
		Vehicle vehicle = mapper.toEntity(input);
		vehicle.setStatus(VehicleStatus.AVAILABLE);
		if(!vehicle.isValid()) {
			throw new VehicleInvalidException("VEHICLEINV", "Invalid vehicle data");
		}
		Vehicle saved = repository.save(vehicle);
		return mapper.toResponse(saved);
	}

}
