package com.github.mauriciolimas.vehicle_resale.api.controller;

import static com.github.mauriciolimas.vehicle_resale.infra.security.Roles.SELLER;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.request.TransactionCompleteRequest;
import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.usecase.CompleteTransactionUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Transactions")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CompleteTransactionController {

	private final CompleteTransactionUseCase completeTransactionUseCase;
	
	@Operation(summary = "Completar a transação", description = "Altera a transação para completada ou rejeitada")
	@PostMapping
	@Transactional
	@RolesAllowed(SELLER)
	public ResponseEntity<TransactionResponse> complete(@RequestBody @Valid TransactionCompleteRequest request) throws BusinessException {
		TransactionResponse response = completeTransactionUseCase.execute(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
