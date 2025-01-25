package com.practice.exception;

//StockUnavailableException if the stock is insufficient.
public class StockUnavailableException extends Exception {

	public StockUnavailableException() {

		System.out.println("Stocks are insufficient for current product!");
	}
}
