package com.github.mauriciolimas.vehicle_resale.infra.database.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity.TransactionJpaEntity;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionJpaEntity, String> {

}
