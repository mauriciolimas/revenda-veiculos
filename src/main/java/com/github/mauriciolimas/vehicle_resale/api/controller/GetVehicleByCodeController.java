package com.github.mauriciolimas.vehicle_resale.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.VehicleController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class GetVehicleByCodeController {

	private final VehicleController controller;
	
	@GetMapping("/{code}")
	public ResponseEntity<?> getByCode(@PathVariable("code") String code) throws BusinessException {
		VehicleResponse response = controller.findByCode(code);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
