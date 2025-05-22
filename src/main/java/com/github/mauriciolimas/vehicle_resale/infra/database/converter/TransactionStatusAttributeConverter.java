package com.github.mauriciolimas.vehicle_resale.infra.database.converter;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransactionStatusAttributeConverter implements AttributeConverter<TransactionStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TransactionStatus attribute) {
		return attribute.getCode();
	}

	@Override
	public TransactionStatus convertToEntityAttribute(Integer dbData) {
		return TransactionStatus.fromCode(dbData);
	}

}
