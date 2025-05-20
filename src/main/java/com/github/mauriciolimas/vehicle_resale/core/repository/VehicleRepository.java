package com.github.mauriciolimas.vehicle_resale.core.repository;

import java.util.Optional;

import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleFilter;

public interface VehicleRepository {

	Optional<Vehicle> findByCode(String code);
	
	Vehicle save(Vehicle vehicle);

	PageData<Vehicle> list(VehicleFilter filter, Pageable pageable);
	
}
