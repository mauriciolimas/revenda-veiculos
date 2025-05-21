package com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class VehicleJpaEntity {

	@Id
	@GeneratedValue(generator = "sale-id-generator")
	@GenericGenerator(name = "sale-id-generator", strategy = "com.github.mauriciolimas.vehicle_resale.infra.database.generator.SaleIdGenerator")
	private String id;
	
	private String brand;
	
	private String model;
	
	private Integer year;
	
	@Enumerated(EnumType.STRING)
	private VehicleColor color;
	
	private BigDecimal price;
	
	private VehicleStatus status;
	
	private VehicleType type;
	
	@CreationTimestamp
	private Instant createdAt;
	
	@UpdateTimestamp
	private Instant updateAt;
	
}
