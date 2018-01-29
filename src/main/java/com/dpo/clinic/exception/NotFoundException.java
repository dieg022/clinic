package com.dpo.clinic.exception;

public class NotFoundException extends Exception {


	private static final String MSG = "La entidad buscada no existe";

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException() {
		super(MSG);
	}

}
