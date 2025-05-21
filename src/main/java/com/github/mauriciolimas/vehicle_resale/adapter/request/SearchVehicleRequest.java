package com.github.mauriciolimas.vehicle_resale.adapter.request;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleFilter;

public record SearchVehicleRequest(VehicleFilter filter, Pageable pageable) {}
