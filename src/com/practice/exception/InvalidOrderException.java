package com.practice.exception;

//For invalid order quantities.
public class InvalidOrderException extends Exception {

	public InvalidOrderException() {
		System.out.println("Quantity of order placed is invalid!!");
	}
}
