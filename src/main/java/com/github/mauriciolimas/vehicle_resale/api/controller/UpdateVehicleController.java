package com.github.mauriciolimas.vehicle_resale.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.VehicleMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleDTO;
import com.github.mauriciolimas.vehicle_resale.adapter.request.VehicleUpdateRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.VehicleResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.VehicleController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Vehicles")
@RestController
@RequestMapping(path = "/vehicles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UpdateVehicleController {

	private final VehicleController controller;
	private final VehicleMapper mapper;
	
	@Operation(summary = "Atualizar veículo", description = "Atualiza um veículo já cadastrado")
	@Transactional
	@PutMapping("/{code}")
	public ResponseEntity<?> update(@RequestBody @Valid VehicleUpdateRequest request, @PathVariable("code") String code) throws BusinessException {
		VehicleDTO vehicleDTO = mapper.toDTO(request, code);
		VehicleResponse response = controller.update(vehicleDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
