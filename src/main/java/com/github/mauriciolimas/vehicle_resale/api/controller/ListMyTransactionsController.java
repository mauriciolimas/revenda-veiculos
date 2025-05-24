package com.github.mauriciolimas.vehicle_resale.api.controller;

import static com.github.mauriciolimas.vehicle_resale.infra.security.Roles.BUYER;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauriciolimas.vehicle_resale.adapter.response.MyTransaction;
import com.github.mauriciolimas.vehicle_resale.application.controller.TransactionController;
import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.transaction.TransactionFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;

@Tag(name = "Transactions")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ListMyTransactionsController {

	private final TransactionController controller;
	
	@Operation(summary = "Listar transações do usuários logado", description = "Lista todas as transações do usuário autenticado")
	@GetMapping("/my")
	@RolesAllowed(BUYER)
	public ResponseEntity<?> myTransactions(TransactionFilter filter, Pageable pageable) throws BusinessException {
		PageData<MyTransaction> response = controller.listMyTransactions(filter, pageable);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
