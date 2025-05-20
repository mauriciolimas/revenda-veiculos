package com.github.mauriciolimas.vehicle_resale.api.controller;

import org.springframework.http.HttpStatus;
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

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class UpdateVehicleController {

	private final VehicleController controller;
	private final VehicleMapper mapper;
	
	@Transactional
	@PutMapping("/{code}")
	public ResponseEntity<?> update(@RequestBody VehicleUpdateRequest request, @PathVariable("code") String code) throws BusinessException {
		VehicleDTO vehicleDTO = mapper.toDTO(request, code);
		VehicleResponse response = controller.update(vehicleDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
