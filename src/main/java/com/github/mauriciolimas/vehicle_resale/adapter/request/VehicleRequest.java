package com.github.mauriciolimas.vehicle_resale.adapter.request;

import java.math.BigDecimal;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

public record VehicleRequest(
	String brand,
	String model,
	Integer year,
	VehicleColor color,
	BigDecimal price,
	VehicleType type
) {}
