package com.axpe.prueba.exception;

public class PricesException extends Exception {

	private static final long serialVersionUID = 1L;

	public PricesException() { }

	public PricesException(String errorMessage) {
		super(errorMessage);
	}
}
