package com.practice.exception;

//For non-existent orders in the cart.
public class OrderNotFoundException extends Exception {

	public OrderNotFoundException(String message) {
		super(message);
	}
}
