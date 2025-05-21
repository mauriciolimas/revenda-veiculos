package com.github.mauriciolimas.vehicle_resale.infra.database.mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity.VehicleJpaEntity;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface VehicleJpaMapper {

	@Mapping(target = "code", source = "id")
	Vehicle toEntity(VehicleJpaEntity entity);
	
	@Mapping(target = "id", source = "code")
	VehicleJpaEntity toJpaEntity(Vehicle vehicle);
}
