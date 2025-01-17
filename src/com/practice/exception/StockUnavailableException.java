package com.practice.exception;

//StockUnavailableException if the stock is insufficient.
public class StockUnavailableException extends Exception {

	public StockUnavailableException(String message) {
		super(message);
	}
}
