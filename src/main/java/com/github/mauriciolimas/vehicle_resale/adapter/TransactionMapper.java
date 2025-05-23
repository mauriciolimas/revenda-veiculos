package com.github.mauriciolimas.vehicle_resale.adapter;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface TransactionMapper {

	@Mapping(target = "code", source = "code")
	@Mapping(target = "vehicle", source = "transaction", qualifiedByName = "concatName")
	@Mapping(target = "price", source = "vehicle.price")
	@Mapping(target = "buyer", source = "transaction", qualifiedByName = "concatBuyer")
	@Mapping(target = "status", source = "status")
	TransactionResponse toResponse(Transaction transaction);
	
	@Named("concatName")
	default String concatName(Transaction transaction) {
		return String.format("%s | %s - %s", transaction.getVehicle().getCode(), transaction.getVehicle().getBrand(),
				transaction.getVehicle().getModel());
	}
	
	@Named("concatBuyer")
	default String concatBuyer(Transaction transaction) {
		return String.format("%s - %s", transaction.getBuyer().getId(), transaction.getBuyer().getName());
	}
}