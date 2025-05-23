package com.github.mauriciolimas.vehicle_resale.api.controller;

import static com.github.mauriciolimas.vehicle_resale.infra.security.Roles.SELLER;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.request.TransactionCompleteRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.usecase.CompleteTransactionUseCase;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/transaction")
public class CompleteTransactionController {

	private final CompleteTransactionUseCase completeTransactionUseCase;
	
	@PostMapping
	@Transactional
	@RolesAllowed(SELLER)
	public ResponseEntity<?> complete(@RequestBody @Valid TransactionCompleteRequest request) throws BusinessException {
		TransactionResponse response = completeTransactionUseCase.execute(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
