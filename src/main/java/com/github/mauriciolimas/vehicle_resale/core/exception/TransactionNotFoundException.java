package com.github.mauriciolimas.vehicle_resale.core.exception;

public class TransactionNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException(String code) {
		super("TRANSNOTFOUND", String.format("Transaction %s not found", code));
	}
}
