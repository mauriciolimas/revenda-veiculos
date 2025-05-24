package com.github.mauriciolimas.vehicle_resale.infra.database.converter;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VehicleTypeAttributeConverter implements AttributeConverter<VehicleType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(VehicleType attribute) {
		return attribute.getCode();
	}

	@Override
	public VehicleType convertToEntityAttribute(Integer dbData) {
		return VehicleType.fromCode(dbData);
	}

}
