package com.github.mauriciolimas.vehicle_resale.adapter;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleDTO;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleUpdateRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface VehicleMapper {

	Vehicle toEntity(VehicleRequest request);
	
	VehicleResponse toResponse(Vehicle vehicle);
	
	@Mapping(target = "code", source = "code")
	VehicleDTO toDTO(VehicleUpdateRequest request, String code);
	
	@Mapping(target = "code", ignore = true)
	void mapProperties(VehicleDTO dto, @MappingTarget Vehicle vehicle);
}
