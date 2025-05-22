package com.github.mauriciolimas.vehicle_resale.infra.database.mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity.TransactionJpaEntity;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface TransactionMapper {

	@Mapping(target = "code", source = "id")
	@Mapping(target = "status", source = "status")
	@Mapping(target = "buyer.id", source = "buyerId")
	@Mapping(target = "buyer.name", source = "buyerName")
	@Mapping(target = "vehicle.code", source = "vehicleId")
	@Mapping(target = "vehicle.brand", source = "vehicleBrand")
	@Mapping(target = "vehicle.model", source = "vehicleModel")
	@Mapping(target = "vehicle.price", source = "value")
	Transaction toEntity(TransactionJpaEntity entity);
	
	@Mapping(target = "id", source = "code")
	@Mapping(target = "value", source = "vehicle.price")
	@Mapping(target = "vehicleId", source = "vehicle.code")
	@Mapping(target = "vehicleBrand", source = "vehicle.brand")
	@Mapping(target = "vehicleModel", source = "vehicle.model")
	@Mapping(target = "buyerId", source = "buyer.id")
	@Mapping(target = "buyerName", source = "buyer.name")
	@Mapping(target = "status", source = "status")
	TransactionJpaEntity toJpaEntity(Transaction transaction);
}
