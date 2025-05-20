package com.github.mauriciolimas.vehicle_resale.infra.database.converter;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VehicleStatusAttributeConverter implements AttributeConverter<VehicleStatus, Integer>{

	@Override
	public Integer convertToDatabaseColumn(VehicleStatus attribute) {
		return attribute.getCode();
	}

	@Override
	public VehicleStatus convertToEntityAttribute(Integer dbData) {
		return VehicleStatus.fromCode(dbData);
	}

}
