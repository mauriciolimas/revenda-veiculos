package com.github.mauriciolimas.vehicle_resale.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.VehicleController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.infra.security.Roles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Vehicles")
@RestController
@RequestMapping(path = "/vehicles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CreateVehicleController {

	private final VehicleController controller;
	
	@Operation(summary = "Cadastrar novo veículo", description = "Cadastra um novo veículo no catálogo")
	@PostMapping
	@Transactional
	@RolesAllowed(Roles.SELLER)
	public ResponseEntity<?> create(@RequestBody @Valid VehicleRequest request) throws BusinessException {
		VehicleResponse response = controller.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
