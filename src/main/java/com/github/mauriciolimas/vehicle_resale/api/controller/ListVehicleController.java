package com.github.mauriciolimas.vehicle_resale.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.VehicleController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleFilter;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class ListVehicleController {

	private final VehicleController controller;
	
	@GetMapping
	public ResponseEntity<?> list(VehicleFilter filter, Pageable pageable) throws BusinessException {
		PageData<VehicleResponse> page = controller.list(filter, pageable);
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}
