package com.github.mauriciolimas.vehicle_resale.adapter.request;

import java.math.BigDecimal;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VehicleUpdateRequest(
		@NotNull
		@NotBlank
		@Size(min = 1, max = 50)
		String brand,
		
		@NotNull
		@NotBlank
		@Size(min = 1, max = 100)
		String model,
		
		@NotNull
		Integer year,
		
		@NotNull
		VehicleColor color,
		
		@NotNull
		BigDecimal price,
		
		@NotNull
		VehicleType type,
		
		@NotNull
		VehicleStatus status
) {}
