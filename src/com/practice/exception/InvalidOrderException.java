package com.practice.exception;

import com.practice.entity.Product;

//For invalid order quantities.
public class InvalidOrderException extends Exception {

	int quantity;
	Product product;

	public InvalidOrderException(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	@Override
	public String getMessage() {

		return "Ordered quantity "+quantity+" is invalid as there are only "+product.getQuantity()+" remaining for this product.";
	}
}
