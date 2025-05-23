package com.github.mauriciolimas.vehicle_resale.api.controller;

import static com.github.mauriciolimas.vehicle_resale.infra.security.Roles.SELLER;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.response.TransactionResponse;
import com.github.mauriciolimas.vehicle_resale.application.controller.TransactionController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/transaction")
public class ListTransactionController {

	private final TransactionController controller;
	
	@GetMapping
	@RolesAllowed(SELLER)
	public ResponseEntity<?> list(@Valid TransactionFilter filter, Pageable pageable) throws BusinessException {
		PageData<TransactionResponse> page = controller.list(filter, pageable);
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
}
