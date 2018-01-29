package com.dpo.clinic.exception;

public class BookRentedException extends Exception {


	private static final String MSG = "El libro ya se encuentra alquilado";

	public BookRentedException() {
		super(MSG);
	}

}
