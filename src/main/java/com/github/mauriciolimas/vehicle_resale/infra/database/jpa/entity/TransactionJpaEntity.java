package com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class TransactionJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", length = 36, nullable = false)
	private String id;
	
	@Column(name = "value", nullable = false)
	private BigDecimal value;
	
	@Column(name = "buyer_name", length = 60, nullable = false)
	private String buyerName;
	
	@Column(name = "buyer_id", length = 36, nullable = false)
	private String buyerId;
	
	@Column(name = "vehicle_id", length = 10, nullable = false)
	private String vehicleId;
	
	@Column(name = "vehicle_brand", length = 50, nullable = false)
	private String vehicleBrand;
	
	@Column(name = "vehicle_model", length = 100, nullable = false)
	private String vehicleModel;
	
	@Column(name = "status", nullable = false)
	private TransactionStatus status;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;
	
}
