package com.github.mauriciolimas.vehicle_resale.core.exception;

public class VehicleInvalidException extends BusinessException {

	private static final long serialVersionUID = 1L;
	public VehicleInvalidException(String code, String description) {
		super(code, description);
	}

}
