package com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle;

import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum VehicleStatus {

	 AVAILABLE(1),
	 SOLD(2),
	 RESERVED(3);
	
	private Integer code;

	public static VehicleStatus fromCode(Integer code) {
		return Stream.of(VehicleStatus.values()).filter(type -> type.getCode().equals(code)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Vehicle status code " + code + " not found"));
	}
}
