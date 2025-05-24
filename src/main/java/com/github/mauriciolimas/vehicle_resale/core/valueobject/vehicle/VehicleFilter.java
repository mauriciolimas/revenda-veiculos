package com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle;

import java.math.BigDecimal;

import org.springdoc.core.annotations.ParameterObject;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ParameterObject
public class VehicleFilter {

	@Parameter(required = false, description = "Montadora / Marca")
	private String brand;
	@Parameter(required = false, description = "Modelo")
	private String model;
	@Parameter(required = false, description = "Ano mínimo")
	private Integer yearMin;
	@Parameter(required = false, description = "Ano máximo")
	private Integer yearMax;
	@Parameter(required = false, description = "Cor do veículo")
	private VehicleColor color;
	@Parameter(required = false, description = "Preço mínimo")
	private BigDecimal priceMin;
	@Parameter(required = false, description = "Preço máximo")
	private BigDecimal priceMax;
	@Parameter(required = false, description = "Tipo de veículo")
	private VehicleType type;
	@Parameter(required = false, description = "Status do veículo")
	private VehicleStatus status;
}
