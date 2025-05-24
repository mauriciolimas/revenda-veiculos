package com.github.mauriciolimas.vehicle_resale.api.controller;

import static com.github.mauriciolimas.vehicle_resale.infra.security.Roles.BUYER;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.request.PurchaseRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.PurchaseResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.PurchaseController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Vehicles")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/purchase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchaseVehicleController {

	private final PurchaseController controller;
	
	@Operation(summary = "Comprar veículo", description = "Comprar veículo através do código do mesmo")
	@PostMapping
	@Transactional
	@RolesAllowed(BUYER)
	public ResponseEntity<?> create(@RequestBody @Valid PurchaseRequest request) throws BusinessException {
		PurchaseResponse response = controller.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
