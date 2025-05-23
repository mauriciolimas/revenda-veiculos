package com.github.mauriciolimas.vehicle_resale.core.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Integer statusCode;
	
	public BusinessException(String code, String message) {
		this.code = code;
		this.message = message;
		this.statusCode = 400;
	}
	
}
