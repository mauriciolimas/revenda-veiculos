package com.github.mauriciolimas.vehicle_resale.util;

import java.math.BigDecimal;

import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleDTO;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleColor;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleType;

public final class VehicleMockUtil {

	public static VehicleRequest vehicleRequest() {
		return new VehicleRequest("Fiat", "Pulse Turbo Hybrid", 2024, VehicleColor.BLACK, BigDecimal.valueOf(149990.90),
				VehicleType.CAR);
	}
	
	public static VehicleRequest invalidVehicleRequest() {
		return new VehicleRequest("Fiat", "Pulse Turbo Hybrid", 2060, VehicleColor.BLACK, BigDecimal.valueOf(149990.90),
				VehicleType.CAR);
	}

	public static Vehicle vehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setCode("SALE000001");
		vehicle.setBrand("Fiat");
		vehicle.setModel("Pulse Turbo Hybrid");
		vehicle.setYear(2024);
		vehicle.setColor(VehicleColor.BLACK);
		vehicle.setPrice(BigDecimal.valueOf(149990.90));
		vehicle.setType(VehicleType.CAR);
		vehicle.setStatus(VehicleStatus.AVAILABLE);
		return vehicle;
	}

	public static VehicleDTO vehicleDTO() {
		return new VehicleDTO("SALE000001", "Fiat", "Pulse Turbo Hybrid", 2024, VehicleColor.BLACK,
				BigDecimal.valueOf(149990.90), VehicleType.CAR, VehicleStatus.AVAILABLE);
	}
}
