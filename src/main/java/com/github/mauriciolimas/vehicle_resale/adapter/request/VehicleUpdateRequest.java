package com.github.mauriciolimas.vehicle_resale.adapter.request;

import java.math.BigDecimal;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

public record VehicleUpdateRequest(
		String brand,
		String model,
		Integer year,
		VehicleColor color,
		BigDecimal price,
		VehicleType type,
		VehicleStatus status
) {}
