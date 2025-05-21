package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleDTO;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class UpdateVehicleUseCase implements UseCase<VehicleDTO, VehicleResponse> {

	private final VehicleRepository repository;
	private final VehicleMapper mapper;
	
	@Override
	public VehicleResponse execute(VehicleDTO input) throws BusinessException {
		Vehicle vehicle = repository.findByCode(input.code()).orElseThrow(() -> new VehicleNotFoundException(input.code()));
		mapper.mapProperties(input, vehicle);
		repository.save(vehicle);
		return mapper.toResponse(vehicle);
	}

}
