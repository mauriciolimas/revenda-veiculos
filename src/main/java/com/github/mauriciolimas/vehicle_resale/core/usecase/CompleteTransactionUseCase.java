package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.adapter.TransactionMapper;
import com.github.mauriciolimas.vehicle_resale.adapter.request.TransactionCompleteRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.entity.Transaction;
import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.exception.TransactionNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.exception.VehicleNotFoundException;
import com.github.mauriciolimas.vehicle_resale.core.repository.TransactionRepository;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionStatus;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleStatus;
import com.github.mauriciolimas.vehicle_resale.infra.configuration.annotation.UseCaseComponent;

import lombok.AllArgsConstructor;

@UseCaseComponent
@AllArgsConstructor
public class CompleteTransactionUseCase implements UseCase<TransactionCompleteRequest, TransactionResponse> {
	
	private final TransactionRepository transactionRepository;
	private final VehicleRepository vehicleRepository;
	private final TransactionMapper mapper;
	
	@Override
	public TransactionResponse execute(TransactionCompleteRequest input) throws BusinessException {
		Transaction transaction = transactionRepository.findByCode(input.getCode())
				.orElseThrow(() -> new TransactionNotFoundException(input.getCode()));
		
		Vehicle vehicle = vehicleRepository.findByCode(transaction.getVehicle().getCode())
			.orElseThrow(() -> new VehicleNotFoundException(transaction.getCode()));
		
		if(input.isCompleted()) {
			vehicle.setStatus(VehicleStatus.SOLD);
			transaction.setStatus(TransactionStatus.COMPLETED);
		} else {
			vehicle.setStatus(VehicleStatus.AVAILABLE);
			transaction.setStatus(TransactionStatus.CANCELLED);
		}
		
		vehicleRepository.save(vehicle);
		transactionRepository.save(transaction);
		
		return mapper.toResponse(transaction);
	}

}
