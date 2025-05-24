package com.github.mauriciolimas.vehicle_resale.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.VehicleController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Vehicles")
@RestController
@RequestMapping(path = "/vehicles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class GetVehicleByCodeController {

	private final VehicleController controller;
	
	@Operation(summary = "Recupera um veículo pelo código", description = "Recupera as informações de um veículo através do código")
	@GetMapping("/{code}")
	@SecurityRequirements
	public ResponseEntity<?> getByCode(@PathVariable("code") String code) throws BusinessException {
		VehicleResponse response = controller.findByCode(code);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
