package com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;

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
	private String id;
	
	private BigDecimal value;
	
	private String buyerName;
	
	private String buyerId;
	
	private String vehicleId;
	
	private String vehicleBrand;
	
	private String vehicleModel;
	
	private TransactionStatus status;
	
	@CreationTimestamp
	private Instant createdAt;
	
	@UpdateTimestamp
	private Instant updatedAt;
	
}
