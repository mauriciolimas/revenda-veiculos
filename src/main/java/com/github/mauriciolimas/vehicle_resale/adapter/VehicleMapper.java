package com.github.mauriciolimas.vehicle_resale.adapter;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface VehicleMapper {

	Vehicle toEntity(VehicleRequest request);
	
	VehicleResponse toResponse(Vehicle vehicle);
}
