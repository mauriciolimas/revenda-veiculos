package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.adapter.request.PurchaseRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.PurchaseResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Buyer;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotAvailableException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.service.AuthenticationService;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.authentication.User;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class PurchaseVehicleUseCase implements UseCase<PurchaseRequest, PurchaseResponse> {
	
	private final VehicleRepository vehicleRepository;
	private final TransactionRepository transactionRepository;
	private final AuthenticationService authenticationService;
	
	@Override
	public PurchaseResponse execute(PurchaseRequest input) throws BusinessException {
		Vehicle vehicle = vehicleRepository.findByCode(input.code()).orElseThrow(() -> new VehicleNotFoundException(input.code()));
		
		if(!vehicle.getStatus().equals(VehicleStatus.AVAILABLE)) {
			throw new VehicleNotAvailableException(input.code());
		}
		
		Buyer buyer = getBuyerData();
		
		Transaction transaction = new Transaction(vehicle, buyer);
		Transaction saved = transactionRepository.save(transaction);
		
		vehicle.setStatus(VehicleStatus.RESERVED);
		
		vehicleRepository.save(vehicle);
		
		return new PurchaseResponse(saved.getCode(), saved.getVehicle().getPrice(), saved.getStatus().name());
	}
	
	private Buyer getBuyerData() {
		User user = authenticationService.getAuthenticatedUser();
		return new Buyer(user.getId(), user.getName(), user.getEmail());
	}

}
