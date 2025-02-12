package com.practice.entity;

import com.practice.exception.InvalidOrderException;
import com.practice.exception.StockUnavailableException;

//Represents an order placed by a customer.
public class Order {

	private int orderId;
	private Customer customer;
	private Product product;
	private int quantity;

	//Constructor to initialize an order.
	public Order(int orderId, Customer customer, Product product, int quantity) throws InvalidOrderException, StockUnavailableException {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		//Checks if product are available or not if not throws exception
		if( quantity < 1 || quantity > this.product.getQuantity()){
			throw new InvalidOrderException(quantity, this.product);
		}
		else{
			this.quantity = quantity;
			product.reduceStock(quantity);
		}
	}

	//Method calculateTotal() to calculate and return the total price of the order.
	public double calculateTotal() {

		return product.getPrice() * this.quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	//Checks if product are available or not if not throws exception
	public void setQuantity(int quantity) throws InvalidOrderException, StockUnavailableException {
		if( quantity < 1 || quantity > this.product.getQuantity()){
			throw new InvalidOrderException(quantity, this.product);
		}
		else{
			this.quantity = quantity;
			this.product.reduceStock(quantity);
		}
	}

	//toString() to display order details.
	@Override
	public String toString() {
		return "\n[orderId=" + orderId + ", customer=" + customer.getName() + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
	
}
