package com.sabre.hospitality.controller.v1;

public class ThrottlingException extends Exception {

	private static final long serialVersionUID = 1L;

	public ThrottlingException() {
		super("Currently service cannot satisfy your request.");
	}

}
