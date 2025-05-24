package com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

import jakarta.persistence.Column;
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
	@Column(name = "id", length = 10, nullable = false)
	private String id;
	
	@Column(name = "brand", length = 50, nullable = false)
	private String brand;
	
	@Column(name = "model", length = 100, nullable = false)
	private String model;
	
	@Column(name = "year", nullable = false)
	private Integer year;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "color", length = 50, nullable = false)
	private VehicleColor color;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "status", nullable = false)
	private VehicleStatus status;
	
	@Column(name = "type", nullable = false)
	private VehicleType type;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private Instant updateAt;
	
}
