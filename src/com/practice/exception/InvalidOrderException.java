package com.practice.exception;

//For invalid order quantities.
public class InvalidOrderException extends Exception {

	public InvalidOrderException(String message) {
		super(message);
	}
}
