package com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleFilter {

	private String brand;
	private String model;
	private Integer yearMin;
	private Integer yearMax;
	private VehicleColor color;
	private BigDecimal priceMin;
	private BigDecimal priceMax;
	private VehicleType type;
	private VehicleStatus status;
}
