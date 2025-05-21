package com.github.mauriciolimas.vehicle_resale.core.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	private String code;
	private String brand;
	private String model;
	private Integer year;
	private VehicleColor color;
	private BigDecimal price;
	private VehicleType type;
	private VehicleStatus status;
	
	public boolean isValid() {
		LocalDate now = LocalDate.now().plus(1, ChronoUnit.YEARS);
		return this.year <= now.getYear();
	}
}
