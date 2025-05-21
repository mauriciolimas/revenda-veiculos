package com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle;

import java.util.stream.Stream;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum VehicleType {

	CAR(1),
    MOTORCYCLE(2),
    TRUCK(3),
    VAN(4),
    SUV(5),
    BUS(6),
    PICKUP(7);
    
    private Integer code;

	public static VehicleType fromCode(Integer code) {
		return Stream.of(VehicleType.values()).filter(type -> type.getCode().equals(code)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Vehicle Type code " + code + " not found"));
	}
    
}
