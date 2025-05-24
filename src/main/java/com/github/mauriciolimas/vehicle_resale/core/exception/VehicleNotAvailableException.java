package com.github.mauriciolimas.vehicle_resale.core.exception;

public class VehicleNotAvailableException extends BusinessException {

	private final static String DEFAULT_MESSAGE = "Vehicle %s not available";
	
	private static final long serialVersionUID = 1L;
	public VehicleNotAvailableException(String code) {
		super("VEHICNOTAVA", String.format(DEFAULT_MESSAGE, code));
	}

}
