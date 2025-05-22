package com.github.mauriciolimas.vehicle_resale.application.controller;

import org.springframework.stereotype.Component;

import com.github.mauriciolimas.vehicle_resale.adapter.request.PurchaseRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.PurchaseResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.usecase.PurchaseVehicleUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PurchaseController {

	private final PurchaseVehicleUseCase purchaseVehicleUseCase;
	
	public PurchaseResponse create(PurchaseRequest request) throws BusinessException {
		return purchaseVehicleUseCase.execute(request);
	}
	
}
