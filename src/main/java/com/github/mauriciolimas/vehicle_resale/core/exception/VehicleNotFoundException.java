package com.github.mauriciolimas.vehicle_resale.core.exception;

public class VehicleNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public VehicleNotFoundException(String code) {
		super("VEHICNOTFOUND", String.format("Vehicle %s not found", code));
	}


}
