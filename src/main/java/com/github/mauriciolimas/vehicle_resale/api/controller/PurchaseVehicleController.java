package com.github.mauriciolimas.vehicle_resale.api.controller;

import static com.github.mauriciolimas.vehicle_resale.infra.security.Roles.BUYER;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.request.PurchaseRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.PurchaseResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.PurchaseController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/purchase")
public class PurchaseVehicleController {

	private final PurchaseController controller;
	
	@PostMapping
	@Transactional
	@RolesAllowed(BUYER)
	public ResponseEntity<?> create(@RequestBody @Valid PurchaseRequest request) throws BusinessException {
		PurchaseResponse response = controller.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
